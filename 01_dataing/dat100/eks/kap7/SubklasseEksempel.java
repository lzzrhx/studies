package kap7;

// Subklasse for SuperklasseEksempel

public class SubklasseEksempel extends SuperklasseEksempel {
    private String beskrivelse;

    public SubklasseEksempel(String navn, String beskrivelse) {
        super(navn);
        this.beskrivelse = beskrivelse;
    }

    @Override
    public String toString() {
        return super.getId() + " " + navn + " " + beskrivelse;
    }
}
