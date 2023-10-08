/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

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
