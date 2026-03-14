package src;

import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class PersonCrud {
    // Objektvariabler
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
   
    // Konstruktør
    public PersonCrud() {}
    
    // Legg til ny person
    public void lagrePerson(Person p) {    
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(p);
            tx.commit();
        
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }
    
    // Hent info om person
    public Person hentPerson(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Person.class, id);
        } finally {
            em.close();
        }
    }
    
    // Hent liste over alle personer
    public List<Person> hentAllePersoner() {
        EntityManager em = emf.createEntityManager();
        String jpqlQuery = "SELECT p FROM Person p ORDER BY p.id";
        try {
            TypedQuery<Person> query = em.createQuery(jpqlQuery, Person.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    // Hent liste over alle personer ved bruk av "named query" (fra Person.java)
    /*public List<Person> hentAllePersonerNQ() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Person> query = em.createNamedQuery("hentAllePersoner", Person.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }*/
    
    // Oppdater info om person
    public void oppdaterPerson(int id, String navn) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Person p = em.find(Person.class, id);
            p.navn(navn);
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    // Slett person
    public void slettPerson(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Person p = em.find(Person.class, id);
            em.remove(p);
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

}
