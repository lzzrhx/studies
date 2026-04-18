package no.hvl.dat107;

import jakarta.persistence.*;

@Entity
@Table(schema = "oblig3")
public class Avdeling {

    // Objektvariabler
    @Id
    @GeneratedValue
    private int id;

    @Column(length = 50)
    private String navn;

    @OneToOne
    @JoinColumn(name = "sjef", nullable = false)
    private Ansatt sjef;
    
    // Konstruktører
    public Avdeling() {}
    public Avdeling(String navn, Ansatt sjef) {
        this.navn = navn;
        this.sjef = sjef;
    }
    
    // Getters / setters
    public int id()               { return id; }
    public String navn()          { return navn; }
    public void navn(String navn) { this.navn = navn; }
    public Ansatt sjef()          { return sjef; }
    public void sjef(Ansatt sjef) { this.sjef = sjef; }

    // Strengrepresentasjon av objektet
    public String toString() {
        return String.format("[Avdeling] id=%d, navn=%s, sjef=%d", id, navn, sjef.id());
    }

    // Sammenligning av objekter
    public boolean equals(Avdeling avdeling) {
        return this.id == avdeling.id;
    }
}
