/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema;

/**
 *
 * @author fauza
 */
public final class Cinema extends Film {
    private final String cinemaName;

    public Cinema(String title, String genre, int duration, String cinemaName) {
        super(title, genre, duration);
        this.cinemaName = cinemaName;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    @Override
    public void displayInfo() {
        System.out.println("Bioskop: " + getCinemaName());
        System.out.println("Judul Film: " + getTitle());
        System.out.println("Genre: " + getGenre());
        System.out.println("Durasi: " + getDuration() + " minutes");
    }
}