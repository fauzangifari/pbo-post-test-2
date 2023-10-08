/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
