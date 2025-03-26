# Mini Proyek Pemrograman Berorientasi Obyek 2

## Informasi Proyek

- **Mata Kuliah:** Pemrograman Berorientasi Obyek 2  
- **Dosen Pengampu:** [Muhammad Ikhwan Fathulloh](https://github.com/Muhammad-Ikhwan-Fathulloh)  
- **Kelompok:** 1  
- **Proyek:** Sistem Manajemen Produk  
- **Dibuat oleh:**  
  - **Nama:** [Bayu Aji Prayoga](https://github.com/BayuAjiPrayoga)  
  - **NPM:** 23552011194  
  - **Kelas:** TIF RP-23 CNS A  

---

## Judul Studi Kasus

**Manajemen Produk (ManaPro)**  

---

## Penjelasan Studi Kasus

Aplikasi ini digunakan untuk mempermudah proses pengelolaan produk dan transaksi dalam sebuah sistem kasir sederhana. Aplikasi ini memiliki fitur untuk:  
- Menambah, melihat, memperbarui, dan menghapus produk  
- Mencari produk berdasarkan nama  
- Memproses transaksi  
- Melihat riwayat transaksi  

Aplikasi ini berbasis **Java** dengan antarmuka berbasis teks.

---

## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance
Inheritance memungkinkan suatu kelas untuk mewarisi atribut dan metode dari kelas lain. Dalam kode ini, inheritance tidak diterapkan karena setiap kelas memiliki tanggung jawab yang spesifik dan tidak ada hierarki yang jelas.

---

### 2. Encapsulation
Encapsulation diterapkan dengan baik dalam proyek ini. Atribut di kelas `Product` bersifat `private` dan hanya dapat diakses melalui metode getter dan setter. Hal ini memastikan bahwa data dalam objek dilindungi dari akses langsung dari luar kelas.

#### Implementasi Encapsulation dalam Kode:
```java
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
```

---

### 3. Polymorphism
Polymorphism diterapkan melalui constructor overloading di kelas `Product` dan overriding metode `toString()` untuk memberikan representasi string yang lebih informatif.

#### Implementasi Polymorphism dalam Kode:
```java
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
```

---

### 4. Abstraction
Abstraction diterapkan melalui kelas `ProductOperations`, yang menyembunyikan detail implementasi query SQL dari pengguna aplikasi. Pengguna hanya perlu memanggil metode seperti `addProduct()`, `getProducts()`, dll., tanpa mengetahui bagaimana query SQL dijalankan.

#### Implementasi Abstraction dalam Kode:
```java
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
```

---

## Struktur Tabel Aplikasi

### Tabel `products`
```sql
CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DOUBLE NOT NULL,
    stock INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### Tabel `transactions`
```sql
CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    total_price DOUBLE NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES products(id)
);
```

---

## Tampilan Aplikasi

### Menu Utama
```
=============================
<<<Product Management Menu>>>
=============================
1. Add Product
2. View All Products
3. Update Product
4. Delete Product
5. Search Product by Name
6. Process Transaction
7. View Transaction History
=============================
0. Exit
```

### Contoh Output

#### Menambah Produk
```
Enter product name: Pensil
Enter product description: Pensil kayu berkualitas tinggi
Enter product price: 2000
Enter product stock: 100
Product added successfully!
```

#### Melihat Semua Produk
```
All Products:
Product{id=1, name='Pensil', description='Pensil kayu berkualitas tinggi', price=2000.0, stock=100}
```

#### Memproses Transaksi
```
Enter Product ID for transaction: 1
Enter quantity to purchase: 5
Transaction successful!
Total Price: 10000.0
```

#### Melihat Riwayat Transaksi
```
Transaction History:
Transaction ID: 1, Product: Pensil, Quantity: 5, Total Price: 10000.0, Date: 2025-03-26 10:00:00
```

---

## Demo Proyek

- **Github:** [Link Github](#)  
- **Youtube:** [Link Youtube](#)
