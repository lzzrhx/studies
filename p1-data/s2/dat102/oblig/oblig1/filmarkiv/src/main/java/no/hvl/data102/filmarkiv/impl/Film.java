package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {

    // Objektvariabler
    private int nr;
    private String tittel;
    private int aar;
    private Sjanger sjanger;
    private String filmselskap;
    private String produsent;

    // Tom konstruktør med standardverdier
    public Film() {
    }

    // Konstruktør
    public Film(int nr, String tittel, int aar, Sjanger sjanger, String filmselskap, String produsent) {
        this.nr = nr;
        this.produsent = produsent;
        this.tittel = tittel;
        this.aar = aar;
        this.sjanger = sjanger;
        this.filmselskap = filmselskap;
    }

    // Getter for nr
    public int nr() {
        return nr;
    }

    // Setter for nr
    public void nr(int nr) {
        this.nr = nr;
    }

    // Getter for produsent
    public String produsent() {
        return produsent;
    }

    // Setter for produsent
    public void produsent(String produsent) {
        this.produsent = produsent;
    }

    // Getter for tittel
    public String tittel() {
        return tittel;
    }

    // Setter for tittel
    public void tittel(String tittel) {
        this.tittel = tittel;
    }

    // Getter for aar
    public int aar() {
        return aar;
    }

    // Setter for aar
    public void aar(int aar) {
        this.aar = aar;
    }

    // Getter for sjanger
    public Sjanger sjanger() {
        return sjanger;
    }

    // Setter for sjanger
    public void sjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    // Getter for filmselskap
    public String filmselskap() {
        return filmselskap;
    }

    // Setter for filmselskap
    public void filmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Film film = (Film) obj;
        return this.nr == film.nr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nr);
    }

    @Override
    public String toString() {
        return String.format("nr: %d, tittel: %s, år: %d, sjanger: %s, filmselskap: %s, produsent: %s", nr, tittel, aar, sjanger.toString(), filmselskap, produsent);
    }
}
