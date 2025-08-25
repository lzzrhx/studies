package kap6;

import static java.lang.System.*;

public class Student {

    // Klassevariabler
    private static int antall = 0;

    // Objektvariabler
    private int nr;
    private String fornavn, etternavn;

    // Konstruktør
    public Student(String fornavn, String etternavn) {
        this.nr = antall++;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public void skrivUt() {
        out.println(this.nr + ": " + this.navn());
    }

    public String navn() {
        return this.etternavn + ", " + this.fornavn;
    }

    public void endreEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }
}
