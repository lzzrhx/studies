package no.hvl.dat107;

import jakarta.persistence.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

@Entity
@Table(schema = "oblig3")
public class Ansatt {

    // Objektvariabler
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(unique = true, length = 4)
    private String brukernavn;
    
    @Column(length = 50)
    private String fornavn;
    
    @Column(length = 50)
    private String etternavn;
   
    private LocalDate startdato;
    
    @Column(length = 50)
    private String stilling;

    private int lonn;

    @ManyToOne
    @JoinColumn(name = "avdeling", nullable = false)
    private Avdeling avdeling;
    
    // Konstruktører
    public Ansatt() {}
    public Ansatt(String brukernavn, String fornavn, String etternavn, String startdato, String stilling, String lonn, Avdeling avdeling) {
        this.brukernavn = brukernavn;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.startdato(startdato);
        this.stilling = stilling;
        this.lonn(lonn);
        this.avdeling = avdeling;
    }
    
    // Getters/setters
    public int id()                            { return id; }
    public String brukernavn()                 { return brukernavn; }
    public void brukernavn(String brukernavn)  { this.brukernavn = brukernavn; }
    public String fornavn()                    { return fornavn; }
    public void fornavn(String fornavn)        { this.fornavn = fornavn; }
    public String etternavn()                  { return etternavn; }
    public void etternavn(String etternavn)    { this.etternavn = etternavn; }
    public LocalDate startdato()               { return startdato; }
    public String startdatoAsString()          { return startdato.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")); }
    public void startdato(LocalDate startdato) { this.startdato = startdato; }
    public String stilling()                   { return stilling; }
    public void stilling(String stilling)      { this.stilling = stilling; }
    public int lonn()                          { return lonn; }
    public void lonn(int lonn)                 { this.lonn = lonn; }
    public void lonn(String lonn)              { this.lonn = Integer.parseInt(lonn); }
    public Avdeling avdeling()                 { return avdeling; }
    public void avdeling(Avdeling avdeling)    { this.avdeling = avdeling; }
    public void startdato(String startdato)    { this.startdato = LocalDate.parse(startdato, DateTimeFormatter.ofPattern("dd-MM-yyyy")); }

    // Sammenligning av objekter
    public boolean equals(Ansatt ansatt) {
        return this.id == ansatt.id;
    }

    // Strengrepresentasjon av objektet
    public String toString() {
        return String.format(
                "[Person] id=%d, brukernavn=%s, fornavn=%s, etternavn=%s, startdato=%s, stilling=%s, månedslønn=%,d, avdeling=%d",
                id, brukernavn, fornavn, etternavn, startdato, stilling, lonn, avdeling.id()
        );
    }

}
