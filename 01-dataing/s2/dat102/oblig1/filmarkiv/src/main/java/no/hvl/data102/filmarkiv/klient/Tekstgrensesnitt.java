package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.*;
import no.hvl.data102.filmarkiv.impl.*;

import java.util.Scanner;

public class Tekstgrensesnitt {

    private static String lesTastatur(Scanner scanner, String message) {
        System.out.print(message + ": ");
        return scanner.nextLine();
    }

    public static void leggTilFilm(FilmarkivADT filmarkiv, Film film) {
        filmarkiv.leggTilFilm(film);
        System.out.print("Ny film lagt til: ");
        printFilm(film);
    }

    public static Film lesFilm(Scanner scanner) {
        System.out.println("Legg til ny film:");
        int nr = Integer.parseInt(lesTastatur(scanner, "Nr"));
        String tittel = lesTastatur(scanner, "Tittel");
        int aar = Integer.parseInt(lesTastatur(scanner, "År"));
        Sjanger sjanger = Sjanger.valueOf(lesTastatur(scanner, "Sjanger").toUpperCase());
        String filmselskap = lesTastatur(scanner, "Filmselskap");
        String produsent = lesTastatur(scanner, "Produsent");
        return new Film(nr, tittel, aar, sjanger, filmselskap, produsent);
    }

    public static void printFilm(Film film) {
        System.out.println("[Film] " + film);
    }

    public static void printSokTittel(FilmarkivADT filmarkiv, String delstreng) {
        System.out.println("Filmarkiv søk etter film med tittel som inneholder \"" + delstreng + "\":");
        for (Film film : filmarkiv.sokTittel(delstreng)) {
            printFilm(film);
        }
    }

    public static void printSokProdusent(FilmarkivADT filmarkiv, String delstreng) {
        System.out.println("Filmarkiv søk etter film med produsent som inneholder \"" + delstreng + "\":");
        for (Film film : filmarkiv.sokProdusent(delstreng)) {
            printFilm(film);
        }
    }

    public static void printStatistikk(FilmarkivADT arkiv) {
        System.out.println("Statistikk for filmarkiv:");
        System.out.println("Antall filmer: " + arkiv.antall());
        for (Sjanger sjanger : Sjanger.values()) {
            System.out.println("Antall filmer i sjanger " + sjanger.toString() + ": " + arkiv.antall(sjanger));
        }
    }
}
