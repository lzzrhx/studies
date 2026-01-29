package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.impl.*;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Filmarkiv implements FilmarkivADT {

    // Objektvariabler
    Film[] filmer;
    int antall;

    // Konstruktør
    public Filmarkiv(int kapasitet) {
        filmer = new Film[kapasitet];
    }

    @Override
    public Film finnFilm(int nr) {
        for (int i = 0; i < antall; i++) {
            if (filmer[i].nr() == nr) {
                return filmer[i];
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film film) {
        if (antall+1 > filmer.length) {
            filmer = Arrays.copyOf(filmer, filmer.length * 2);
        }
        filmer[antall] = film;
        antall++;
    }

    @Override
    public boolean slettFilm(int nr) {
        for (int i = 0; i < antall; i++) {
            if (filmer[i].nr() == nr) {
                filmer[i] = filmer[antall-1];
                filmer[antall-1] = null;
                antall--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Film[] sokTittel(String tekst) {
        List<Film> res = new ArrayList<Film>();
        for (int i = 0; i < antall; i++) {
            if (filmer[i].tittel().toLowerCase().contains(tekst.toLowerCase())) {
                res.add(filmer[i]);
            }
        }
        return Utils.filmListToArr(res);
    }

    @Override
    public Film[] sokProdusent(String tekst) {
        List<Film> res = new ArrayList<Film>();
        for (int i = 0; i < antall; i++) {
            if (filmer[i].produsent().toLowerCase().contains(tekst.toLowerCase())) {
                res.add(filmer[i]);
            }
        }
        return Utils.filmListToArr(res);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int n = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i].sjanger() == sjanger) {
                n++;
            }
        }
        return n;
    }

    @Override
    public int antall() {
        return antall;
    }
}
