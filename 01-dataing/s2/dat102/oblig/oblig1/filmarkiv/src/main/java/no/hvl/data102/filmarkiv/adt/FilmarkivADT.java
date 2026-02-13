package no.hvl.data102.filmarkiv.adt;

import no.hvl.data102.filmarkiv.impl.*;

public interface FilmarkivADT {
    /**
     * Hente en film med gitt nr fra arkivet
     * @param nr nummer på film som skal hentes.
     * @return film med gitt nr. Om nr ikke finnes, returneres null.
     */
    Film finnFilm(int nr);

    /**
     * Legger til en ny film.
     * @param film
     */
    void leggTilFilm(Film film);

    /**
     * Sletter en film med gitt nr.
     * @param nr filmnr på film som skal slettes.
     */
    boolean slettFilm(int nr);

    /**
     * Søker og henter filmer med en gitt delstreng i tittelen.
     * @param tekst delstreng som må være i tittel.
     * @return tabell med filmer som har delstreng i tittel.
     */
    Film[] sokTittel(String tekst);

    /**
     * Søker og henter filmer med en gitt delstreng i filmprodusent.
     * @param tekst delstreng som må vøre i filmprodusent.
     * @return tabell med filmer som har delstreng i filmprodusent.
     */
    Film[] sokProdusent(String tekst);

    /**
     * Finner antall filmer med gitt sjanger
     * @param sjanger
     * @return antall filmer av gitt sjanger.
     */
    int antall(Sjanger sjanger);

    /**
     * @return antall filmer i arkivet.
     */
    int antall();
}
