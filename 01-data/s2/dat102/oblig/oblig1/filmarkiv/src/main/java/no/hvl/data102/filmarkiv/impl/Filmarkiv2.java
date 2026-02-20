package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.impl.*;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Filmarkiv2 implements FilmarkivADT {

    // Objektvariabler
    LinearNode<Film> forste;
    int antall;

    // Konstruktør
    public Filmarkiv2() {}
    
    @Override
    public Film finnFilm(int nr) {
        LinearNode<Film> node = forste;
        while (node != null) {
            if (node.data.nr() == nr) {
                return node.data;
            }
            node = node.neste;
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film film) {
        LinearNode<Film> node = new LinearNode<Film>(film);
        if (forste == null) {
            forste = node;
        } else {
            LinearNode<Film> siste = forste;
            while (siste.neste != null) {
                siste = siste.neste;
            }
            siste.neste = node;
        }
        antall++;
    }

    @Override
    public boolean slettFilm(int nr) {
        LinearNode<Film> node = forste;
        LinearNode<Film> forrige = null;
        while (node != null) {
            if (node.data.nr() == nr) {
                if (forrige != null) {
                    forrige.neste = node.neste;
                } else {
                    forste = null;
                }
                antall--;
                return true;
            }
            forrige = node;
            node = node.neste;
        }
        return false;
    }

    @Override
    public Film[] sokTittel(String tekst) {
        List<Film> res = new ArrayList<Film>();
        LinearNode<Film> node = forste;
        while (node != null) {
            if (node.data.tittel().toLowerCase().contains(tekst.toLowerCase())) {
                res.add(node.data);
            }
            node = node.neste;
        }
        return Utils.filmListToArr(res);
    }

    @Override
    public Film[] sokProdusent(String tekst) {
        List<Film> res = new ArrayList<Film>();
        LinearNode<Film> node = forste;
        while (node != null) {
            if (node.data.produsent().toLowerCase().contains(tekst.toLowerCase())) {
                res.add(node.data);
            }
            node = node.neste;
        }
        return Utils.filmListToArr(res);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int n = 0;
        LinearNode<Film> node = forste;
        while (node != null) {
            if (node.data.sjanger() == sjanger) {
                n++;
            }
            node = node.neste;
        }
        return n;
    }

    @Override
    public int antall() {
        return antall;
    }
}
