package src;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

@Entity
@Table(schema = "oblig3")
public class Ansatt {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    // Objektvariabler
    @Id private Integer id;
    private String brukernavn;
    private String fornavn;
    private String etternavn;
    private String startdato;
    private String stilling;
    private int lonn;
    private int avdeling;
    
    // Konstruktører
    public Ansatt() {}
    public Ansatt(String brukernavn, String fornavn, String etternavn, String startdato, String stilling, int lonn, int avdeling) {
        this.brukernavn = brukernavn;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.startdato = startdato;
        this.stilling = stilling;
        this.lonn = lonn;
        this.avdeling = avdeling;
    }
    
    // Getters / setters
    int id()                           { return id; }
    String brukernavn()                { return brukernavn; }
    void brukernavn(String brukernavn) { this.brukernavn = brukernavn; }
    String fornavn()                   { return fornavn; }
    void fornavn(String fornavn)       { this.fornavn = fornavn; }
    String etternavn()                 { return etternavn; }
    void etternavn(String etternavn)   { this.etternavn = etternavn; }
    String startdato()                 { return startdato; }
    void startdato(String startdato)   { this.startdato = startdato; }
    String stilling()                  { return stilling; }
    void stilling(String stilling)     { this.stilling = stilling; }
    int lonn()                         { return lonn; }
    void lonn(int lonn)                { this.lonn = lonn; }
    int avdeling()                     { return avdeling; }
    void avdeling(int avdeling)        { this.avdeling = avdeling; }

    public boolean equals(Ansatt ansatt) { return this.id == ansatt.id; }

    // Stringrepresentasjon av objektet
    public String toString() {
        return String.format(
            "[Person] id=%d, brukernavn=%s, fornavn=%s, etternavn=%s, startdato=%s, stilling=%s, månedslønn=%,d, avdeling=%d",
            id, brukernavn, fornavn, etternavn, startdato, stilling, lonn, avdeling
        );
    }
    
    // Hent info om ansatt
    public static Ansatt hent(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Ansatt.class, id);
        } finally {
            em.close();
        }
    }
    
    // Hent liste av alle ansatte fra gitt avdeling
    public static List<Ansatt> hentAlleFraAvdeling(Avdeling avdeling) {
        EntityManager em = emf.createEntityManager();
        String jpqlQuery = "SELECT a FROM Ansatt a WHERE a.avdeling = " + avdeling.id() + " AND NOT a.id = " + avdeling.sjef() + " ORDER BY a.id";
        try {
            TypedQuery<Ansatt> query = em.createQuery(jpqlQuery, Ansatt.class);
            List<Ansatt> res = query.getResultList();
            res.add(0, Ansatt.hent(avdeling.sjef()));
            return res;
        } finally {
            em.close();
        }
    }
}
