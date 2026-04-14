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
public class Avdeling {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    // Objektvariabler
    @Id private Integer id;
    private String navn;
    private int sjef;
    
    // Konstruktører
    public Avdeling() {}
    public Avdeling(String navn, int sjef) {
        this.navn = navn;
        this.sjef = sjef;
    }
    
    // Getters / setters
    int id()               { return id; }
    String navn()          { return navn; }
    void navn(String navn) { this.navn = navn; }
    int sjef()             { return sjef; }
    void sjef(int sjef)    { this.sjef = sjef; }

    // Stringrepresentasjon av objektet
    public String toString() {
        return String.format(
            "[Avdeling] id=%d, navn=%s, sjef=%d",
            id, navn, sjef
        );
    }
    
    // Hent liste av alle avdelinger
    public static List<Avdeling> hentAlle() {
        EntityManager em = emf.createEntityManager();
        String jpqlQuery = "SELECT a FROM Avdeling a ORDER BY a.id";
        try {
            TypedQuery<Avdeling> query = em.createQuery(jpqlQuery, Avdeling.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    // Hent liste av alle avdelinger
    public List<Ansatt> hentAnsatte() {
        return Ansatt.hentAlleFraAvdeling(this);
    }
    
    /*
    public static void printAlle() {
        System.out.println("Avdelinger:");
        Avdeling.hentAlle().forEach(System.out::println);
    }
    */
}
