/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.manapro;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ManaPro {

    public static void main(String[] args) {
        try {
            ProductOperations operations = new ProductOperations();
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("===============================");
                System.out.println("<<< Product Management Menu >>>");
                System.out.println("===============================");
                System.out.println("1. Add Product");
                System.out.println("2. View All Products");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Search Product by Name");
                System.out.println("6. Process Transaction");
                System.out.println("7. View Transaction History");
                System.out.println("===============================");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter product name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter product description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter product price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Enter product stock: ");
                        int stock = scanner.nextInt();
                        operations.addProduct(new Product(name, description, price, stock));
                        break;

                    case 2:
                        System.out.println("All Products:");
                        operations.getProducts().forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("Enter Product ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new description: ");
                        String newDescription = scanner.nextLine();
                        System.out.print("Enter new price: ");
                        double newPrice = scanner.nextDouble();
                        System.out.print("Enter new stock: ");
                        int newStock = scanner.nextInt();
                        operations.updateProduct(updateId, newName, newDescription, newPrice, newStock);
                        break;

                    case 4:
                        System.out.print("Enter Product ID to delete: ");
                        int deleteId = scanner.nextInt();
                        operations.deleteProduct(deleteId);
                        break;

                    case 5:
                        System.out.print("Enter Product Name to search: ");
                        String searchName = scanner.nextLine();
                        List<Product> products = operations.searchProductByName(searchName);
                        if (!products.isEmpty()) {
                            products.forEach(System.out::println);
                        } else {
                            System.out.println("No products found with the given name!");
                        }
                        break;

                    case 6:
                        System.out.print("Enter Product ID for transaction: ");
                        int transactionId = scanner.nextInt();
                        System.out.print("Enter quantity to purchase: ");
                        int quantity = scanner.nextInt();
                        operations.processTransaction(transactionId, quantity);
                        break;

                        case 7:
    System.out.println("Transaction History:");
    List<String> transactions = operations.getTransactionHistory();
    if (!transactions.isEmpty()) {
        transactions.forEach(System.out::println);
    } else {
        System.out.println("No transactions found!");
    }
    break;

                    case 0:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 0);

            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}