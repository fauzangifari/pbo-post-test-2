# **Nama    : Muhammad Fauzan Gifari**
# **NIM     : 2209116042**

## Source Code

### Cinema.java
```java
package cinema;
package main;
import cinema.*;
/**
 *
 * @author fauza
 */
import java.util.Scanner;

public class Posttest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("=============================");
            System.out.println("|    Welcome to Zanflix     |");
            System.out.println("=============================");
            System.out.println("|   1. Display All Films    |");
            System.out.println("|   2. Create Film          |");
            System.out.println("|   3. Update Film          |");
            System.out.println("|   4. Delete Film          |");
            System.out.println("|   0. Exit                 |");
            System.out.println("=============================");
            System.out.print("Masukkan pilihan anda: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> displayAllFilms();
                case 2 -> createFilm();
                case 3 -> updateFilm();
                case 4 -> deleteFilm();
                case 0 -> System.out.println("Terimakasih telah menggunakan program ini!");
                default -> System.out.println("Pilihan tidak tersedia, silahkan coba lagi");
            }
        } while (choice != 0);
    }

    private static void createFilm() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Judul Film: ");
        String title = scanner.nextLine().toUpperCase();
        System.out.print("Masukkan Genre Film: ");
        String genre = scanner.nextLine();
        System.out.print("Masukkan Durasi Film (menit): ");
        int duration = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan nama Bioskop (Contoh: Theater 1 dst): ");
        String cinemaName = scanner.nextLine();

        Cinema cinema = new Cinema(title, genre, duration, cinemaName);
        FilmBooking.addFilm(cinema);
        System.out.println("Film berhasil ditambahkan!");
    }

    private static void displayAllFilms() {
        System.out.println("\nList Film:");
        FilmBooking.displayAllFilms();
    }

    private static void updateFilm() {
        Scanner scanner = new Scanner(System.in);
        displayAllFilms();
        System.out.print("Masukkan Judul Film yang ingin diupdate: ");
        String titleToUpdate = scanner.nextLine().toUpperCase();
        System.out.print("Masukkan Judul Film yang baru: ");
        String newTitle = scanner.nextLine().toUpperCase();
        System.out.print("Masukkan Genre Film yang baru: ");
        String newGenre = scanner.nextLine();
        System.out.print("Masukkan Durasi Film yang baru (menit): ");
        int newDuration = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan nama Bioskop yang baru: ");
        String newCinemaName = scanner.nextLine();

        Cinema updatedFilm = new Cinema(newTitle, newGenre, newDuration, newCinemaName);

        if (FilmBooking.updateFilm(titleToUpdate, updatedFilm)) {
            System.out.println("Film berhasil diupdate!");
        } else {
            System.out.println("Film tidak tersedia!");
        }
    }

    private static void deleteFilm() {
        Scanner scanner = new Scanner(System.in);
        displayAllFilms();
        System.out.print("Masukkan Judul Film yang ingin dihapus: ");
        String titleToDelete = scanner.nextLine().toUpperCase();

        if (FilmBooking.deleteFilm(titleToDelete)) {
            System.out.println("Film berhasil dihapus!");
        } else {
            System.out.println("Film tidak tersedia!");
        }
    }
}

```
### FilmBooking.java
```java
package cinema;

import java.util.ArrayList;

/**
 * @author fauza
 */
public final class FilmBooking {
    private static final ArrayList<Film> filmList = new ArrayList<>();

    public static void addFilm(Film film) {
        filmList.add(film);
    }

    public static void displayAllFilms() {
        for (Film film : filmList) {
            film.displayInfo();
            System.out.println();
        }
    }

    public static boolean updateFilm(String oldTitle, Film updatedFilm) {
        for (int i = 0; i < filmList.size(); i++) {
            Film film = filmList.get(i);
            if (film.getTitle().equals(oldTitle)) {
                filmList.set(i, updatedFilm);
                return true;
            }
        }
        return false;
    }

    public static boolean deleteFilm(String title) {
        for (Film film : filmList) {
            if (film.getTitle().equals(title)) {
                filmList.remove(film);
                return true;
            }
        }
        return false;
    }
}
    
```

### Film.java
```java
package cinema;

/**
 * @author fauza
 */
public abstract class Film {
    private final String title;
    private final String genre;
    private final int duration;

    public Film(String title, String genre, int duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    public final String getTitle() {
        return title;
    }

    public final String getGenre() {
        return genre; }

    public final int getDuration() {
        return duration;
    }

    public abstract void displayInfo();
}
```
---

## Penjelasan Source Code

### Cinema.java
Pada class Cinema.java terdapat beberapa method yang digunakan untuk mengatur program, yaitu:
- `createFilm()` 
- `displayAllFilms()` 
- `updateFilm()`
- `deleteFilm()` 

Masing - masing method tersebut memiliki fungsi yang berbeda-beda, seperti:
- `createFilm()` digunakan untuk membuat film baru dengan memasukkan judul, genre, durasi, dan nama bioskop.
- `displayAllFilms()` digunakan untuk menampilkan semua film yang ada.
- `updateFilm()` digunakan untuk mengupdate film yang ada dengan memasukkan judul film yang ingin diupdate, judul film baru, genre film baru, durasi film baru, dan nama bioskop baru.
- `deleteFilm()` digunakan untuk menghapus film yang ada dengan memasukkan judul film yang ingin dihapus.

### FilmBooking.java
Pada class FilmBooking.java terdapat beberapa method yang digunakan untuk mengatur program, yaitu:
- `addFilm()`
- `displayAllFilms()`
- `updateFilm()`
- `deleteFilm()`

Masing - masing method tersebut memiliki fungsi yang berbeda-beda, seperti:
- `addFilm()` digunakan untuk menambahkan film baru.
- `displayAllFilms()` digunakan untuk menampilkan semua film yang ada.
- `updateFilm()` digunakan untuk mengupdate film yang ada.
- `deleteFilm()` digunakan untuk menghapus film yang ada.

Perbedaan antara class Cinema.java dan FilmBooking.java adalah bahwa dalam class Cinema.java terdapat method `main()` yang berfungsi untuk menjalankan program, sedangkan dalam class FilmBooking.java tidak terdapat method `main()`. Selain itu, dalam class FilmBooking.java terdapat method `addFilm()` yang digunakan untuk menambahkan film baru.

Hubungan antara class Cinema.java dan FilmBooking.java adalah bahwa dalam class Cinema.java terdapat method `createFilm()` yang bertujuan untuk membuat film baru. Untuk melakukan ini, method `createFilm()` memanggil method `addFilm()` yang ada pada class FilmBooking.java. Hal ini dilakukan karena ArrayList `filmList` yang ada dalam class FilmBooking.java memiliki akses yang bersifat private, sehingga tidak dapat diakses langsung dari luar class. Oleh karena itu, class Cinema.java perlu menghubungi class FilmBooking.java melalui method `addFilm()` untuk menambahkan film ke dalam ArrayList `filmList`.

### Film.java
Pada class Film.java terdapat beberapa method yang digunakan untuk mengatur program, yaitu:
- `getTitle()`
- `getGenre()`
- `getDuration()`
- `displayInfo()`

Masing - masing method tersebut memiliki fungsi yang berbeda-beda, seperti:
- `getTitle()` digunakan untuk mendapatkan judul film.
- `getGenre()` digunakan untuk mendapatkan genre film.
- `getDuration()` digunakan untuk mendapatkan durasi film.
- `displayInfo()` digunakan untuk menampilkan informasi film.

Class Film.java adalah sebuah class yang bersifat abstract, yang berarti tidak dapat diinstansiasi langsung, tetapi digunakan sebagai dasar untuk membuat class lain. Class ini memiliki sebuah method abstract bernama `displayInfo()`. Method abstract ini memiliki tugas untuk menampilkan informasi tentang film, namun implementasinya akan didefinisikan di dalam class yang meng-extend (menjadi subclass) dari class Film.java, seperti class Cinema.java.

Selain itu, dalam class Film.java, terdapat beberapa getter yang digunakan untuk mengakses atribut-atribut yang bersifat private dalam class ini. Getter ini memungkinkan untuk mendapatkan nilai dari atribut-atribut seperti judul, genre, dan durasi film secara aman tanpa perlu mengakses atribut tersebut langsung dari luar class.

Dengan kata lain, class Film.java menyediakan kerangka kerja dasar untuk menggambarkan film, dengan method abstrak yang harus diimplementasikan oleh subclass, serta getter untuk mengakses informasi tentang film tersebut.
