package kap7;

// Superklasse for SubklasseEksempel

public class SuperklasseEksempel {
    private static int num = 0;
    // Variablen id har aksessmodifikatoren private og kan kun leses av subklassen med en get metode
    private int id;
    // Variablen navn har aksesmodifikatoren protected og kan leses av subklassen direkte
    protected String navn;

    public SuperklasseEksempel(String navn) {
        this.id = num++;
        this.navn = navn;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return id + " " + navn;
    }
}
