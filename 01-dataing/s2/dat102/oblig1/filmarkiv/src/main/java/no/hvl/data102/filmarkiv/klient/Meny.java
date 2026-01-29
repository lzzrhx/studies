package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {
    private Tekstgrensesnitt tekstgrensesnitt;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv) {
        tekstgrensesnitt = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start() {
        filmarkiv.leggTilFilm(new Film("A Poet", 2025, Sjanger.DRAMA, "Ocúltimo", "Juan Sarmiento G."));
        filmarkiv.leggTilFilm(new Film("Harvest", 2024, Sjanger.DRAMA, "ARTE France Cinéma", "Viola Fügen"));
        filmarkiv.leggTilFilm(new Film("Life, and Nothing More…", 2024, Sjanger.DRAMA, "Kanoon", "Ali Reza Zarrin"));
    }
}
