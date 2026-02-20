package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

import java.util.Scanner;

public class Meny {
    private FilmarkivADT filmarkiv;
    private Scanner scanner;

    public Meny(FilmarkivADT filmarkiv, Scanner scanner) {
        this.filmarkiv = filmarkiv;
        this.scanner = scanner;
        start();
    }

    public void start() {
        Tekstgrensesnitt.leggTilFilm(filmarkiv, new Film(0, "A Poet", 2025, Sjanger.DRAMA, "Ocúltimo", "Juan Sarmiento G."));
        Tekstgrensesnitt.leggTilFilm(filmarkiv, new Film(1, "Harvest", 2024, Sjanger.DRAMA, "ARTE France Cinéma", "Viola Fügen"));
        Tekstgrensesnitt.leggTilFilm(filmarkiv, new Film(2, "Samsara", 2023, Sjanger.DRAMA, "Filmin", "Leire Apellániz"));
        Tekstgrensesnitt.leggTilFilm(filmarkiv, new Film(3, "The Apple", 1998, Sjanger.DRAMA, "Makhmalbaf Film House Productions ", "Marin Karmitz"));
        Tekstgrensesnitt.leggTilFilm(filmarkiv, new Film(4, "Life, and Nothing More…", 1992, Sjanger.DRAMA, "Kanoon", "Ali Reza Zarrin"));
        Tekstgrensesnitt.leggTilFilm(filmarkiv, new Film(5, "Kuroneko", 1968, Sjanger.HORROR, "Nihon Eiga Shinsha", "Kazuo Kuwahara"));
        Tekstgrensesnitt.leggTilFilm(filmarkiv, new Film(6, "To Be or Not to Be", 1942, Sjanger.KOMEDIE, "Romaine Film Corporation", "Ernst Lubitsch"));
        System.out.println();
        Tekstgrensesnitt.printSokTittel(filmarkiv, "not");
        System.out.println();
        Tekstgrensesnitt.printSokProdusent(filmarkiv, "en");
        System.out.println();
        Tekstgrensesnitt.printStatistikk(filmarkiv);
        System.out.println();
        Tekstgrensesnitt.leggTilFilm(filmarkiv, Tekstgrensesnitt.lesFilm(scanner));
    }
}
