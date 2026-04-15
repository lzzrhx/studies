package src;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(schema = "oblig3")
public class Ansatt {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

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
    
    @Column(nullable = false)
    private int avdeling;
    
    // Konstruktører
    public Ansatt() {}
    public Ansatt(String brukernavn, String fornavn, String etternavn, String startdato, String stilling, String lonn, int avdeling) {
        this.brukernavn = brukernavn;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.startdato(startdato);
        this.stilling = stilling;
        this.lonn(lonn);
        this.avdeling = avdeling;
        Ansatt.opprett(this);
    }
    
    // Getters / setters
    int id()                            { return id; }
    String brukernavn()                 { return brukernavn; }
    void brukernavn(String brukernavn)  { this.brukernavn = brukernavn; }
    String fornavn()                    { return fornavn; }
    void fornavn(String fornavn)        { this.fornavn = fornavn; }
    String etternavn()                  { return etternavn; }
    void etternavn(String etternavn)    { this.etternavn = etternavn; }
    LocalDate startdato()               { return startdato; }
    String startdatoAsString()          { return startdato.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")); }
    void startdato(LocalDate startdato) { this.startdato = startdato; }
    String stilling()                   { return stilling; }
    void stilling(String stilling)      { this.stilling = stilling; }
    int lonn()                          { return lonn; }
    void lonn(int lonn)                 { this.lonn = lonn; }
    void lonn(String lonn)              { this.lonn = Integer.parseInt(lonn); }
    int avdeling()                      { return avdeling; }
    void avdeling(int avdeling)         { this.avdeling = avdeling; }
    void startdato(String startdato) {
        try {
            this.startdato = LocalDate.parse(startdato, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException e) {
            this.startdato = LocalDate.parse("01-01-2000", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }
    }

    public boolean equals(Ansatt ansatt) { return this.id == ansatt.id; }

    // Strengrepresentasjon av objektet
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
    
    // Legg til ny ansatt
    public static void opprett(Ansatt a) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(a);
            tx.commit();
        
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }
    
    // Oppdater info om ansatt
    public void oppdater(String brukernavn, String fornavn, String etternavn, String startdato, String stilling, String lonn) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Ansatt a = em.find(Ansatt.class, this.id);
            this.brukernavn(brukernavn);
            this.fornavn(fornavn);
            this.etternavn(etternavn);
            this.startdato(startdato);
            this.stilling(stilling);
            this.lonn(lonn);
            a.brukernavn(brukernavn);
            a.fornavn(fornavn);
            a.etternavn(etternavn);
            a.startdato(startdato);
            a.stilling(stilling);
            a.lonn(lonn);
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }
    
    // Slett ansatt
    public void slett() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Ansatt a = em.find(Ansatt.class, this.id);
            em.remove(a);
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
