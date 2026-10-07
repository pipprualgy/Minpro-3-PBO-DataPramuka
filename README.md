# MINI PROJECT 3 PBO DATA PRAMUKA

## Deskripsi Program

Program ini merupakan berbasis konsol (CLI) yang dirancang untuk mengelola data keorganisasian Pramuka, meliputi pengelolaan data Gugus Depan, Kwartir Ranting (Kwarran), serta Anggota Pramuka yang terbagi menjadi golongan Siswa dan Pembina. Melalui sistem manajemen CRUD (Create, Read, Update, Delete) yang interaktif, aplikasi ini memungkinkan pengguna untuk menambah, melihat, memperbarui, serta menghapus data administrasi kepramukaan dengan mudah melalui menu terstruktur yang dilengkapi validasi input.

## Struktur Package

Struktur proyek ini dibagi ke dalam tiga package utama untuk menerapkan pemisahan tanggung jawab/peran. Package com.mycompany.minprodatapramuka berfungsi sebagai titik awal eksekusi program melalui kelas utama MinproDataPramuka.java. Package Model mewakili lapisan data dan logika entitas yang mencakup kelas abstrak AnggotaPramuka.java, kelas konkret turunan seperti Siswa.java dan Pembina.java, kelas entitas pendukung GugusDepan.java dan Kwarran.java, serta interface InfoPramuka.java. Terakhir, package Controller berisi kelas PramukaController.java yang mengatur alur pemrosesan data dan logika bisnis, serta package View melalui kelas PramukaView.java yang bertugas menangani interaksi antarmuka pengguna di konsol.

```
com.mycompany.minprodatapramuka
│
├── MinproDataPramuka.java         ← Entry point (method main)
│
├── Model                          ← MODEL: struktur data & objek bisnis
│   ├── AnggotaPramuka.java        ← Abstract class (superclass anggota pramuka)
│   ├── Siswa.java                 ← Subclass AnggotaPramuka & implement InfoPramuka
│   ├── Pembina.java               ← Subclass AnggotaPramuka & implement InfoPramuka
│   ├── InfoPramuka.java           ← Interface kontrak informasi tambahan
│   ├── GugusDepan.java            ← Entitas data Gugus Depan
│   └── Kwarran.java               ← Entitas data Kwartir Ranting
│
├── View                           ← VIEW: tampilan & pembacaan input
│   └── PramukaView.java           ← Antarmuka konsol & navigasi menu CLI
│
└── Controller                     ← CONTROLLER: alur & logika bisnis
    └── PramukaController.java     ← Pengatur data, ArrayList, & operasi CRUD

```

## Alur Program
Alur eksekusi program dimulai dari kelas utama MinproDataPramuka yang bertindak sebagai titik masuk (entry point), di mana metode main menginisialisasi objek PramukaController untuk manajemen data dan objek PramukaView untuk antarmuka pengguna, lalu memanggil metode mulai() pada view. Di dalam metode mulai(), program menampilkan menu utama berbasis konsol yang mencakup pilihan pengelolaan Gugus Depan, Kwartir Ranting, Anggota Pramuka, dan opsi untuk keluar dari program. Setiap kali pengguna memilih salah satu menu tersebut, program menggunakan perulangan do-while yang dipadukan dengan validasi input Scanner untuk memastikan masukan angka yang dimasukkan valid sebelum mengarahkan alur ke fungsi sub-menu spesifik. Ketika pengguna memilih menu manajemen Gugus Depan atau Kwartir Ranting, mereka dapat melakukan operasi CRUD seperti memasukkan data baru yang langsung disimpan ke dalam ArrayList di controller, menampilkan seluruh daftar data yang tersimpan, memperbarui informasi berdasarkan kode atau ID, maupun menghapus data dari sistem. Sementara itu, pada menu Anggota Pramuka, alur program memberikan fleksibilitas tambahan bagi pengguna untuk memilih golongan anggota apakah sebagai Siswa (dengan input tingkat pramuka) atau Pembina (dengan input sertifikat hak bina), di mana data objek polimorfik tersebut diproses oleh controller dan ditampilkan kembali secara rinci menggunakan pemanggilan metode overriding dan implementasi interface ketika opsi lihat data dipilih. Siklus menu ini akan terus berulang secara interaktif hingga pengguna memasukkan pilihan untuk keluar, yang kemudian akan menghentikan perulangan dan mengakhiri program.

## Penerapan Encapsulation & Inheritance

Konsep Encapsulation diterapkan dengan cara melindungi data variabel melalui penggunaan modifier private atau protected serta menyediakan metode pengakses berupa getter dan setter di dalam kelas-kelas model seperti AnggotaPramuka.java, Siswa.java, Pembina.java, GugusDepan.java, dan Kwarran.java. Sementara itu, konsep Inheritance (pewarisan) diterapkan pada relasi antara kelas induk AnggotaPramuka.java dengan kelas turunannya yaitu Siswa.java dan Pembina.java, di mana kelas anak mewarisi atribut umum seperti ID anggota, nama, jenis kelamin, kode gugus depan, dan ID kwarran, serta memanfaatkan keyword super() untuk menginisialisasi atribut tersebut di kelas konstruktor turunannya.

### Encapsulation
Encapsulation adalah konsep pembungkusan data (variabel) dan metode ke dalam satu unit, serta pembatasan akses langsung ke variabel dengan menggunakan modifier hak akses (seperti private atau protected) dan menyediakannya melalui metode getter dan setter.

Contoh Penerapan Encapsulation:
```java
public abstract class AnggotaPramuka{
    protected int idAnggota;
    protected String namaAnggota;
    protected String jenisKelamin;
    protected int kodeGugusDepan;
    protected int idKwarran;
    
    public AnggotaPramuka(int idAnggota, String namaAnggota, String jenisKelamin, int kodeGugusDepan, int idKwarran) {
        this.idAnggota = idAnggota;
        this.namaAnggota = namaAnggota;
        this.jenisKelamin = jenisKelamin;
        this.kodeGugusDepan = kodeGugusDepan;
        this.idKwarran = idKwarran;
    }

    public int getIdAnggota() {
        return idAnggota;
    }

    public String getNamaAnggota() {
        return namaAnggota;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public int getKodeGugusDepan() {
        return kodeGugusDepan;
    }

    public int getIdKwarran() {
        return idKwarran;
    }

    public void setIdAnggota(int idAnggota) {
        this.idAnggota = idAnggota;
    }

    public void setNamaAnggota(String namaAnggota) {
        this.namaAnggota = namaAnggota;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public void setKodeGugusDepan(int kodeGugusDepan) {
        this.kodeGugusDepan = kodeGugusDepan;
    }

    public void setIdKwarran(int idKwarran) {
        this.idKwarran = idKwarran;
    }
```

### Inheritance

Inheritance adalah mekanisme di mana sebuah kelas dapat mewarisi atribut dan metode dari kelas lain. Kelas yang mewarisi disebut superclass/parentclass (kelas induk), sedangkan kelas yang mewarisi disebut subclass/childclass (kelas anak).

#### Superclass (AnggotaPramuka.java)
``` java

public abstract class AnggotaPramuka{
    protected int idAnggota;
    protected String namaAnggota;
    protected String jenisKelamin;
    protected int kodeGugusDepan;
    protected int idKwarran;

    public AnggotaPramuka(int idAnggota, String namaAnggota, String jenisKelamin, int kodeGugusDepan, int idKwarran) {
        this.idAnggota = idAnggota;
        this.namaAnggota = namaAnggota;
        this.jenisKelamin = jenisKelamin;
        this.kodeGugusDepan = kodeGugusDepan;
        this.idKwarran = idKwarran;
    }
}

```
#### Subclass (Siswa.java)
```java

public class Siswa extends AnggotaPramuka implements InfoPramuka{
    private String tingkatPramuka;

    public Siswa(int idAnggota, String namaAnggota, String jenisKelamin, int kodeGugusDepan, int idKwarran, String tingkatPramuka) {
        super(idAnggota, namaAnggota, jenisKelamin, kodeGugusDepan, idKwarran);
        this.tingkatPramuka = tingkatPramuka;
    }
}

```

#### Subclass (Pembina.java)
```java

public class Pembina extends AnggotaPramuka implements InfoPramuka{
    private String hakBina;

    public Pembina(int idAnggota, String namaAnggota, String jenisKelamin, int kodeGugusDepan, int idKwarran, String hakBina){
        super(idAnggota, namaAnggota, jenisKelamin, kodeGugusDepan, idKwarran);
        this.hakBina = hakBina;
    }
}

```
## Penerapan Polymorphism & Abstraction

Penerapan Abstraction dapat dilihat pada kelas AnggotaPramuka.java yang dideklarasikan sebagai kelas abstrak beserta metode abstrak tampilkanData(), yang memaksa setiap kelas turunannya untuk mengimplementasikan detail spesifik dari metode tersebut. Di sisi lain, Polymorphism diterapkan dalam dua bentuk: compile-time polymorphism melalui method overloading pada metode tampilkanData() dan tampilkanData(String idNama) di dalam kelas AnggotaPramuka.java, serta run-time polymorphism melalui method overriding pada metode tampilkanData() di kelas Siswa.java dan Pembina.java serta pemrosesan koleksi objek secara dinamis di dalam PramukaView.java.

### Polymorphism

Polimorfisme berarti "banyak bentuk", di mana sebuah objek atau metode dapat memiliki perilaku yang berbeda-beda tergantung pada konteks atau kelas yang mengeksekusinya. Dalam program ini, polimorfisme dibagi menjadi dua jenis:

#### Overloading
```java

public abstract class AnggotaPramuka{
    // ...
    public abstract void tampilkanData();

    public void tampilkanData(String idNama){
            System.out.println(namaAnggota + " (" + idAnggota + ")" );
            tampilkanData();
    }
}

```

#### Overriding
```java

public class Siswa extends AnggotaPramuka implements InfoPramuka{
    private String tingkatPramuka;
    // ...
    @Override
    public void tampilkanData(){
        System.out.println("=== Data Pramuka Siswa ===");
        System.out.println("ID Anggota Pramuka: " + idAnggota);
        System.out.println("Nama Anggota Pramuka: " + namaAnggota);
        System.out.println("Jenis Kelamin: " + jenisKelamin);
        System.out.println("Gugus Depan: " + kodeGugusDepan);
        System.out.println("Asal Kwarran: " + idKwarran);
        System.out.println("Tingkat Pramuka Siswa: " + tingkatPramuka);
    }
    @Override
    public void dataAnggota(){
        System.out.println("Siswa " + namaAnggota + " adalah anggota pramuka tingkat " + tingkatPramuka);
    }
}

```

### Abstraction
Abstraksi adalah konsep menyembunyikan detail implementasi kompleks dan hanya menampilkan fungsionalitas esensial kepada pengguna. Dalam Java, hal ini diwujudkan menggunakan kelas abstrak (abstract class) atau interface yang berisi metode tanpa tubuh (body), sehingga kelas turunannya wajib mendefinisikan isi dari metode tersebut.

Kelas AnggotaPramuka dideklarasikan menggunakan kata kunci abstract dan memiliki metode abstrak tampilkanData() tanpa implementasi di dalamnya:
```java
public abstract class AnggotaPramuka{
    protected int idAnggota;
    protected String namaAnggota;
    protected String jenisKelamin;
    protected int kodeGugusDepan;
    protected int idKwarran;

    public AnggotaPramuka(int idAnggota, String namaAnggota, String jenisKelamin, int kodeGugusDepan, int idKwarran) {
        this.idAnggota = idAnggota;
        this.namaAnggota = namaAnggota;
        this.jenisKelamin = jenisKelamin;
        this.kodeGugusDepan = kodeGugusDepan;
        this.idKwarran = idKwarran;
    }

    // Metode abstrak yang memaksa subclass untuk mengisinya
    public abstract void tampilkanData(); 

    public void tampilkanData(String idNama){
            System.out.println(namaAnggota + " (" + idAnggota + ")" );
            tampilkanData();
    }
}
```
## Penerapan Interface 

Konsep Interface di dalam program ini diterapkan melalui pembuatan antarmuka InfoPramuka.java di dalam package Model yang mendefinisikan sebuah kontrak berupa metode abstrak dataAnggota(). Antarmuka ini kemudian diimplementasikan secara langsung oleh kelas turunan Siswa.java dan Pembina.java, di mana masing-masing kelas menuliskan logika spesifik untuk mencetak informasi detail mengenai status keanggotaan atau sertifikasi hak bina, serta dimanfaatkan dalam proses casting tipe data pada kelas PramukaView.java saat menampilkan daftar keseluruhan anggota pramuka.

### Letak Deklarasi Interface
```java

package Model;

public interface InfoPramuka {
    void dataAnggota();
}

```
### Letak Implementasi pada Subclass (Pembina & Siswa)

#### Siswa.java
```java

public class Siswa extends AnggotaPramuka implements InfoPramuka{
    private String tingkatPramuka;
//...
    @Override
    public void dataAnggota(){
        System.out.println("Siswa " + namaAnggota + " adalah anggota pramuka tingkat " + tingkatPramuka);
    }
}

```

#### Pembina.java
```java

public class Pembina extends AnggotaPramuka implements InfoPramuka{
    private String hakBina;
//...
    @Override
    public void dataAnggota(){
        System.out.println("Pembina " + namaAnggota + " Memiliki Sertifikasi Hak Bina " + hakBina + " pada Nomor Gugus Depan " + kodeGugusDepan);
    }
}

```








