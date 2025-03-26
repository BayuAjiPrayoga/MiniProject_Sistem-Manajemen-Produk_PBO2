package com.mycompany.manapro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductOperations {

    private Connection connection;

    public ProductOperations() throws SQLException {
        connection = DatabaseConnection.getConnection();
    }

    // Create
    public void addProduct(Product product) {
        String query = "INSERT INTO products (name, description, price, stock) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getStock());
            stmt.executeUpdate();
            System.out.println("Product added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    // Update
    public void updateProduct(int id, String newName, String newDescription, double newPrice, int newStock) {
        String query = "UPDATE products SET name = ?, description = ?, price = ?, stock = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newName);
            stmt.setString(2, newDescription);
            stmt.setDouble(3, newPrice);
            stmt.setInt(4, newStock);
            stmt.setInt(5, id);
            stmt.executeUpdate();
            System.out.println("Product updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteProduct(int id) {
        String query = "DELETE FROM products WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Product deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Process Product Transaction
    public void processTransaction(int productId, int quantity) {
        String queryGetStock = "SELECT stock, price FROM products WHERE id = ?";
        String queryUpdateStock = "UPDATE products SET stock = stock - ? WHERE id = ?";
        String queryInsertTransaction = "INSERT INTO transactions (product_id, quantity, total_price) VALUES (?, ?, ?)";
        try (PreparedStatement stmtGetStock = connection.prepareStatement(queryGetStock);
             PreparedStatement stmtUpdateStock = connection.prepareStatement(queryUpdateStock);
             PreparedStatement stmtInsertTransaction = connection.prepareStatement(queryInsertTransaction)) {

            // Get current stock and price
            stmtGetStock.setInt(1, productId);
            try (ResultSet rs = stmtGetStock.executeQuery()) {
                if (rs.next()) {
                    int currentStock = rs.getInt("stock");
                    double price = rs.getDouble("price");

                    // Check if stock is sufficient
                    if (currentStock >= quantity) {
                        // Update stock
                        stmtUpdateStock.setInt(1, quantity);
                        stmtUpdateStock.setInt(2, productId);
                        stmtUpdateStock.executeUpdate();

                        // Calculate total price
                        double totalPrice = price * quantity;

                        // Insert transaction into transactions table
                        stmtInsertTransaction.setInt(1, productId);
                        stmtInsertTransaction.setInt(2, quantity);
                        stmtInsertTransaction.setDouble(3, totalPrice);
                        stmtInsertTransaction.executeUpdate();

                        System.out.println("Transaction successful!");
                        System.out.println("Total Price: " + totalPrice);
                    } else {
                        System.out.println("Insufficient stock! Available stock: " + currentStock);
                    }
                } else {
                    System.out.println("Product not found!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get Transaction History
    public List<String> getTransactionHistory() {
        List<String> transactions = new ArrayList<>();
        String query = "SELECT t.id, p.name, t.quantity, t.total_price, t.transaction_date " +
                       "FROM transactions t " +
                       "JOIN products p ON t.product_id = p.id";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String transaction = "Transaction ID: " + rs.getInt("id") +
                                     ", Product: " + rs.getString("name") +
                                     ", Quantity: " + rs.getInt("quantity") +
                                     ", Total Price: " + rs.getDouble("total_price") +
                                     ", Date: " + rs.getTimestamp("transaction_date");
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    public List<Product> searchProductByName(String searchName) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products WHERE name LIKE ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, "%" + searchName + "%"); // Menggunakan wildcard untuk pencarian
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    products.add(new Product(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("description"),
                            rs.getDouble("price"),
                            rs.getInt("stock")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

}