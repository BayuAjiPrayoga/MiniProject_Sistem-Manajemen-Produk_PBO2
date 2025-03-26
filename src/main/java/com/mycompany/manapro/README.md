<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>README - MANAPRO</title>
</head>
<body>
    <h1>Mini Proyek Pemrograman Berorientasi Obyek 2</h1>

    <ul>
        <li><strong>Mata Kuliah:</strong> Pemrograman Berorientasi Obyek 2</li>
        <li><strong>Dosen Pengampu:</strong> <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
    </ul>

    <h2>Kelompok</h2>
    <ul>
        <li><strong>Kelompok:</strong> 1</li>
        <li><strong>Proyek:</strong> Sistem Manajemen Produk</li>
        <li><strong>Dibuat oleh:</strong></li>
        <ul>
            <li>Nama: <a href="https://github.com/BayuAjiPrayoga">Bayu Aji Prayoga</a></li>
            <li>NPM: 23552011194</li>
            <li>Kelas: TIF RP-23 CNS A</li>
        </ul>
    </ul>

    <h2>Judul Studi Kasus</h2>
    <p>ManaPro</p>

    <h2>Penjelasan Studi Kasus</h2>
    <p>Aplikasi ini digunakan untuk mempermudah proses pengelolaan produk dan transaksi dalam sebuah sistem kasir sederhana. Aplikasi ini memiliki fitur untuk menambah, melihat, memperbarui, menghapus produk, mencari produk berdasarkan nama, memproses transaksi, dan melihat riwayat transaksi. Aplikasi ini berbasis Java dengan antarmuka berbasis teks.</p>

    <h2>Penjelasan 4 Pilar OOP dalam Studi Kasus</h2>

    <h3>1. Inheritance</h3>
    <p>Inheritance memungkinkan suatu kelas untuk mewarisi atribut dan metode dari kelas lain. Dalam kode ini, inheritance tidak diterapkan karena setiap kelas memiliki tanggung jawab yang spesifik dan tidak ada hierarki yang jelas.</p>

    <h3>2. Encapsulation</h3>
    <p>Encapsulation diterapkan dengan baik dalam proyek ini. Atribut di kelas <code>Product</code> bersifat <code>private</code> dan hanya dapat diakses melalui metode getter dan setter. Hal ini memastikan bahwa data dalam objek dilindungi dari akses langsung dari luar kelas.</p>

    <h4>Implementasi Encapsulation dalam Kode:</h4>
    <pre>

<code>
public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private int stock;

    public Product(int id, String name, String description, double price, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    // Getter dan Setter
    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

}
</code>

</pre>

    <h3>3. Polymorphism</h3>
    <p>Polymorphism diterapkan melalui constructor overloading di kelas <code>Product</code> dan overriding metode <code>toString()</code> untuk memberikan representasi string yang lebih informatif.</p>

    <h4>Implementasi Polymorphism dalam Kode:</h4>
    <pre>

<code>
public class Product {
    // Constructor Overloading
    public Product(int id, String name, String description, double price, int stock) { ... }
    public Product(String name, String description, double price, int stock) { ... }

    // Overriding toString()
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

}
</code>

</pre>

    <h3>4. Abstraction</h3>
    <p>Abstraction diterapkan melalui kelas <code>ProductOperations</code>, yang menyembunyikan detail implementasi query SQL dari pengguna aplikasi. Pengguna hanya perlu memanggil metode seperti <code>addProduct()</code>, <code>getProducts()</code>, dll., tanpa mengetahui bagaimana query SQL dijalankan.</p>

    <h4>Implementasi Abstraction dalam Kode:</h4>
    <pre>

<code>
public class ProductOperations {
    public void addProduct(Product product) {
        String query = "INSERT INTO products (name, description, price, stock) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getStock());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
</code>
    </pre>

    <h2>Struktur Tabel Aplikasi</h2>

    <h3>Tabel <code>products</code></h3>
    <pre>

<code>
CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DOUBLE NOT NULL,
    stock INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
</code>
    </pre>

    <h3>Tabel <code>transactions</code></h3>
    <pre>

<code>
CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    total_price DOUBLE NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES products(id)
);
</code>
    </pre>

    <h2>Tampilan Aplikasi</h2>

    <h3>Menu Utama</h3>
    <pre>

# <code>

# <<<Product Management Menu>>>

1.  Add Product
2.  View All Products
3.  Update Product
4.  Delete Product
5.  Search Product by Name
6.  Process Transaction
7.  # View Transaction History
8.  Exit
    </code>
    </pre>

        <h3>Contoh Output</h3>
        <h4>Menambah Produk</h4>
        <pre>

<code>
Enter product name: Pensil
Enter product description: Pensil kayu berkualitas tinggi
Enter product price: 2000
Enter product stock: 100
Product added successfully!
</code>
    </pre>

    <h4>Melihat Semua Produk</h4>
    <pre>

<code>
All Products:
Product{id=1, name='Pensil', description='Pensil kayu berkualitas tinggi', price=2000.0, stock=100}
</code>
    </pre>

    <h4>Memproses Transaksi</h4>
    <pre>

<code>
Enter Product ID for transaction: 1
Enter quantity to purchase: 5
Transaction successful!
Total Price: 10000.0
</code>
    </pre>

    <h4>Melihat Riwayat Transaksi</h4>
    <pre>

<code>
Transaction History:
Transaction ID: 1, Product: Pensil, Quantity: 5, Total Price: 10000.0, Date: 2025-03-26 10:00:00
</code>
    </pre>

    <h2>Demo Proyek</h2>
    <ul>
        <li>Github: <a href="">[Github]</a></li>
        <li>Youtube: <a href="">[Youtube]</a></li>
    </ul>

</body>
</html>
