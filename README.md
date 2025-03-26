# Final Proyek Pemrograman Berorientasi Obyek 1

<ul>
  <li>Mata Kuliah: Pemrograman Berorientasi Obyek 1</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Kelompok

<ul>
  <li>Kelompok: 1</li>
  <li>Proyek: Manajemen Presensi Siswa</li>
  <li>Anggota:</li>
  <ul>
    <li>Ketua: <a href="https://github.com/BayuAjiPrayoga">Bayu Aji Prayoga</a></li>
    <li>Anggota 1: <a href="https://github.com/miuki-rgb">Luki Solihin</a></li>
    <li>Anggota 2: <a href="https://github.com/AzizaFirda">Aziza Firdaus</a></li>
  </ul>
</ul>

## Judul Studi Kasus

<p>Sistem Presensi Siswa (SIPRESIS) Berbasis Java GUI dan JavaFX</p>

## Penjelasan Studi Kasus

<p>Aplikasi ini digunakan untuk mempermudah proses absensi siswa di sekolah. Aplikasi memiliki dua peran utama: Administrator dan Guru. Administrator bertugas mengelola data siswa dan akun pengguna (guru/admin), sedangkan guru mengelola absensi harian siswa yang ada di kelasnya. Aplikasi ini berbasis Java GUI dan JavaFX untuk memberikan tampilan yang interaktif dan user-friendly.</p>


## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance
Inheritance memungkinkan suatu kelas untuk mewarisi atribut dan metode dari kelas lain. Dalam kode ini, kelas `Admin` dan `Guru` mewarisi sifat dari kelas `User`, sehingga tidak perlu menulis ulang atribut dan metode yang sama.

#### Implementasi Inheritance dalam Kode:

Kelas `User` sebagai Parent Class:
```java
package model;

public abstract class User {
    private int id;
    private String nama;
    private String username;
    private String password;
    private String role;

    public User(int id, String nama, String username, String password, String role) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public abstract boolean login();

    // Getter dan Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
```

Kelas `Admin` sebagai Child Class:
```java
package model;

public class Admin extends User {
    public Admin(int id, String nama, String username, String password) {
        super(id, nama, username, password, "ADMIN");
    }

    @Override
    public boolean login() {
        // Implementasi login untuk admin
        return true;
    }

    // Metode spesifik admin
    public void kelolaSiswa() {
        System.out.println("Mengelola data siswa");
    }

    public void kelolaAkun() {
        System.out.println("Mengelola akun pengguna");
    }

    public void lihatLaporanAbsensi() {
        System.out.println("Melihat laporan absensi siswa");
    }
}
```

Kelas `Guru` sebagai Child Class:
```java
package model;

public class Guru extends User {
    private String kelasYangDiajar;

    public Guru(int id, String nama, String username, String password, String kelasYangDiajar) {
        super(id, nama, username, password, "GURU");
        this.kelasYangDiajar = kelasYangDiajar;
    }

    @Override
    public boolean login() {
        // Implementasi login untuk guru
        return true;
    }

    // Metode spesifik guru
    public void inputPresensi() {
        System.out.println("Input presensi siswa kelas " + kelasYangDiajar);
    }

    public void lihatKehadiran() {
        System.out.println("Melihat data kehadiran kelas " + kelasYangDiajar);
    }

    public String getKelasYangDiajar() {
        return kelasYangDiajar;
    }

    public void setKelasYangDiajar(String kelasYangDiajar) {
        this.kelasYangDiajar = kelasYangDiajar;
    }
}
```

#### Alasan Penggunaan Inheritance:
- **Penggunaan Kembali Kode**: Dengan menggunakan inheritance, kita dapat menghindari duplikasi kode. Kelas `Admin` dan `Guru` mewarisi properti dan metode dari kelas `User`, sehingga kita tidak perlu menulis ulang kode yang sama.
- **Pemeliharaan Lebih Mudah**: Perubahan pada kelas induk (`User`) akan secara otomatis diterapkan pada kelas turunan (`Admin` dan `Guru`), sehingga pemeliharaan kode menjadi lebih mudah.
- **Struktur Data Lebih Rapi**: Semua yang berhubungan dengan identitas user dikelompokkan dalam satu kelas induk (`User`), membuat struktur data lebih rapi dan mudah dipahami.
- **Memudahkan Maintenance**: Jika ada perubahan pada properti atau metode user, cukup ubah di kelas `User`.

### 2. Encapsulation
Encapsulation atau enkapsulasi adalah konsep di mana data dalam sebuah objek dilindungi dari akses langsung dari luar kelas. Dalam proyek ini, variabel instance di kelas seperti `User`, `Siswa`, dan `Presensi` menggunakan modifier `private` dan menyediakan getter dan setter untuk mengakses dan memodifikasi nilai-nilai tersebut.

#### Implementasi Encapsulation dalam Kode:

Kelas `User`:
```java
package model;

public abstract class User {
    private int id;
    private String nama;
    private String username;
    private String password;
    private String role;

    public User(int id, String nama, String username, String password, String role) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public abstract boolean login();

    // Getter dan Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
```

#### Alasan Penggunaan Encapsulation:
- **Perlindungan Data**: Dengan enkapsulasi, data dalam objek dilindungi dari akses langsung dari luar kelas. Ini memastikan bahwa data hanya dapat diakses dan dimodifikasi melalui metode yang telah ditentukan (getter dan setter).
- **Kontrol Akses**: Enkapsulasi memungkinkan kita untuk mengontrol bagaimana data diakses dan dimodifikasi, sehingga kita dapat mencegah perubahan yang tidak diinginkan.
- **Meningkatkan Keamanan**: Dengan membatasi akses langsung ke data, kita dapat meningkatkan keamanan aplikasi.
- **Memudahkan Debugging**: Dengan enkapsulasi, kita dapat dengan mudah melacak dan memperbaiki kesalahan yang terjadi pada data.

### 3. Polymorphism
Polymorphism atau polimorfisme adalah konsep di mana metode yang sama dapat memiliki implementasi yang berbeda pada kelas yang berbeda. Dalam proyek ini, metode `login()` di kelas `User` dapat memiliki implementasi yang berbeda di kelas `Admin` dan `Guru`.

#### Implementasi Polymorphism dalam Kode:

Kelas `Admin`:
```java
package model;

public class Admin extends User {
    public Admin(int id, String nama, String username, String password) {
        super(id, nama, username, password, "ADMIN");
    }

    @Override
    public boolean login() {
        // Implementasi login untuk admin
        return true;
    }

    // Metode spesifik admin
    public void kelolaSiswa() {
        System.out.println("Mengelola data siswa");
    }

    public void kelolaAkun() {
        System.out.println("Mengelola akun pengguna");
    }

    public void lihatLaporanAbsensi() {
        System.out.println("Melihat laporan absensi siswa");
    }
}
```

Kelas `Guru`:
```java
package model;

public class Guru extends User {
    private String kelasYangDiajar;

    public Guru(int id, String nama, String username, String password, String kelasYangDiajar) {
        super(id, nama, username, password, "GURU");
        this.kelasYangDiajar = kelasYangDiajar;
    }

    @Override
    public boolean login() {
        // Implementasi login untuk guru
        return true;
    }

    // Metode spesifik guru
    public void inputPresensi() {
        System.out.println("Input presensi siswa kelas " + kelasYangDiajar);
    }

    public void lihatKehadiran() {
        System.out.println("Melihat data kehadiran kelas " + kelasYangDiajar);
    }

    public String getKelasYangDiajar() {
        return kelasYangDiajar;
    }

    public void setKelasYangDiajar(String kelasYangDiajar) {
        this.kelasYangDiajar = kelasYangDiajar;
    }
}
```

#### Alasan Penggunaan Polymorphism:
- **Fleksibilitas**: Polimorfisme memungkinkan kita untuk menggunakan metode yang sama dengan cara yang berbeda pada objek yang berbeda. Misalnya, metode `login()` di kelas `User` dapat memiliki implementasi yang berbeda di kelas `Admin` dan `Guru`.
- **Kode Lebih Sederhana**: Dengan polimorfisme, kita dapat menulis kode yang lebih sederhana dan lebih mudah dipahami, karena kita dapat menggunakan metode yang sama untuk berbagai jenis objek.
- **Memudahkan Ekstensi**: Polimorfisme memudahkan kita untuk menambahkan fungsionalitas baru tanpa mengubah kode yang sudah ada.
- **Meningkatkan Reusabilitas**: Dengan polimorfisme, kita dapat menggunakan kembali metode yang sama pada berbagai jenis objek, meningkatkan reusabilitas kode.

### 4. Abstraction
Abstraction atau abstraksi adalah konsep di mana detail implementasi disembunyikan dan hanya menunjukkan fungsionalitas penting kepada pengguna. Dalam proyek ini, kelas abstrak `User` mendefinisikan metode `login()` yang harus diimplementasikan oleh kelas turunan seperti `Admin` dan `Guru`.

#### Implementasi Abstraction dalam Kode:

Kelas `User`:
```java
package model;

public abstract class User {
    private int id;
    private String nama;
    private String username;
    private String password;
    private String role;

    public User(int id, String nama, String username, String password, String role) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public abstract boolean login();

    // Getter dan Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
```

#### Alasan Penggunaan Abstraction:
- **Menyembunyikan Detail Implementasi**: Abstraksi memungkinkan kita untuk menyembunyikan detail implementasi dan hanya menunjukkan fungsionalitas penting kepada pengguna. Ini membuat kode lebih mudah dipahami dan digunakan.
- **Fokus pada Fungsionalitas Utama**: Dengan abstraksi, kita dapat fokus pada fungsionalitas utama dari kelas tanpa harus memikirkan detail implementasi yang rumit.
- **Memudahkan Penggunaan Kembali Kode**: Abstraksi memungkinkan kita untuk menggunakan kembali kode dengan cara yang lebih fleksibel dan efisien.
- **Meningkatkan Keamanan**: Dengan menyembunyikan detail implementasi, kita dapat meningkatkan keamanan aplikasi dengan mencegah akses langsung ke bagian-bagian yang sensitif.

</p>
<h2 id="struktur-tabel-aplikasi">Struktur Tabel Aplikasi</h2>
<p>[Desain Tabel Database]<img src="https://github.com/BayuAjiPrayoga/TUBESProject_ProgramE-Presensi_Kelompok1_TIFRP23B/blob/main/asset/STRUKTUR%20DATABASE.png" alt="pict11"></p>
<h2 id="tampilan-aplikasi">Tampilan Aplikasi</h2>
<p>[Tampilan Login]<img src="https://github.com/BayuAjiPrayoga/TUBESProject_ProgramE-Presensi_Kelompok1_TIFRP23B/blob/main/asset/TAMPILAN%20LOGIN.png" alt="pict1"></p>
<p>[Tampilan Dashboard Admin]<img src="https://github.com/BayuAjiPrayoga/TUBESProject_ProgramE-Presensi_Kelompok1_TIFRP23B/blob/main/asset/DASHBOARD%20ADMIN.png" alt="pict2"></p>
<p>[Tampilan Admin Dashboard-Fitur Daftar Pengguna]<img src="https://github.com/BayuAjiPrayoga/TUBESProject_ProgramE-Presensi_Kelompok1_TIFRP23B/blob/main/asset/FITUR%20DAFTAR%20PENGGUNA.png" alt="pict3"></p>
<p>[Tampilan Admin Dashboard-Fitur Daftar Siswa]<img src="https://github.com/BayuAjiPrayoga/TUBESProject_ProgramE-Presensi_Kelompok1_TIFRP23B/blob/main/asset/FITUR%20DAFTAR%20SISWA.png" alt="pict4"></p>
<p>[Tampilan Admin Dashboard-Fitur Edit Data Kehadiran]<img src="https://github.com/BayuAjiPrayoga/TUBESProject_ProgramE-Presensi_Kelompok1_TIFRP23B/blob/main/asset/FITUR%20EDIT%20DATA%20KEHADIRAN%20PADA%20ADMIN.png" alt="pict5"></p>
<p>[Tampilan Admin Dashboard-Fitur Laporan Absensi Siswa]<img src="https://github.com/BayuAjiPrayoga/TUBESProject_ProgramE-Presensi_Kelompok1_TIFRP23B/blob/main/asset/FITUR%20LAPORAN%20ABSENSI%20SISWA%20PADA%20ADMIN.png" alt="pict6"></p>
<p>[Tampilan Admin Dashboard-Fitur Tambah Data Kehadiran]<img src="https://github.com/BayuAjiPrayoga/TUBESProject_ProgramE-Presensi_Kelompok1_TIFRP23B/blob/main/asset/FITUR%20TAMBAH%20DATA%20KEHADIRAN%20PADA%20ADMIN.png" alt="pict7"></p>
<p>[Tampilan Admin Dashboard-Fitur Tambah Pengguna]<img src="https://github.com/BayuAjiPrayoga/TUBESProject_ProgramE-Presensi_Kelompok1_TIFRP23B/blob/main/asset/FITUR%20TAMBAH%20PENGGUNA%20BARU.png" alt="pict8"></p>
<p>[Tampilan Admin Dashboard-Fitur Tambah Siswa Baru]<img src="https://github.com/BayuAjiPrayoga/TUBESProject_ProgramE-Presensi_Kelompok1_TIFRP23B/blob/main/asset/FITUR%20TAMBAH%20SISWA%20BARU.png" alt="pict9"></p>
<p>[Tampilan Dashboard Guru-Fitur Input Presensi Siswa]<img src="https://github.com/BayuAjiPrayoga/TUBESProject_ProgramE-Presensi_Kelompok1_TIFRP23B/blob/main/asset/FITUR%20INPUT%20PRESENSI%20SISWA.png" alt="pict10"></p>
<p>[Tampilan Dashboard Guru-Fitur Lihat Kehadiran Siswa]<img src="https://github.com/BayuAjiPrayoga/TUBESProject_ProgramE-Presensi_Kelompok1_TIFRP23B/blob/main/asset/FITUR%20LIHAT%20KEHADIRAN%20SISWA.png" alt="pict11"></p>
<p>[Tampilan Dashboard Guru-Fitur Laporan Kehadiran Siswa]<img src="https://github.com/BayuAjiPrayoga/TUBESProject_ProgramE-Presensi_Kelompok1_TIFRP23B/blob/main/asset/FITUR%20LAPORAN%20KEHADIRAN%20PADA%20GURU.png" alt="pict12"></p>
<h2 id="demo-proyek">Demo Proyek</h2>
<ul>
  <li>Github: <a href="https://github.com/BayuAjiPrayoga/TUBESProject_ProgramE-Presensi_Kelompok1_TIFRP23B/tree/main">[Github]</a></li>
  <li>Youtube: <a href="https://youtu.be/PDujNavyRm4?feature=shared">[Youtube]</a></li>
</ul>

</body>
