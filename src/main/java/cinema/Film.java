/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
