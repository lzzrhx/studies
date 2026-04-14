package src;

import java.util.List;
//import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class AnsattCrud {
    // Objektvariabler
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
   
    // Konstruktør
    public AnsattCrud() {}
    
    // Legg til ny ansatt
    public void opprett(Ansatt a) {    
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
    
    // Hent info om ansatt
    public Ansatt hent(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Ansatt.class, id);
        } finally {
            em.close();
        }
    }
    
    // Hent liste over alle ansatte
    public List<Ansatt> hentAlle() {
        EntityManager em = emf.createEntityManager();
        String jpqlQuery = "SELECT a FROM Ansatt a ORDER BY a.id";
        try {
            TypedQuery<Ansatt> query = em.createQuery(jpqlQuery, Ansatt.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    /*
    // Oppdater info om ansatt
    public void oppdater(int id, String brukernavn, String fornavn, String etternavn, String startdato, String stilling, int lonn, int avdeling) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Ansatt a = em.find(Ansatt.class, id);
            a.brukernavn(brukernavn);
            a.fornavn(fornavn);
            a.etternavn(etternavn);
            a.startdato(startdato);
            a.stilling(stilling);
            a.lonn(lonn);
            a.avdeling(avdeling);
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }*/

    // Slett ansatt
    public void slett(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Ansatt a = em.find(Ansatt.class, id);
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
