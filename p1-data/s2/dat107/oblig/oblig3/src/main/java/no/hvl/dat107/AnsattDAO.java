package no.hvl.dat107;

import jakarta.persistence.*;

import java.util.List;

public class AnsattDAO {
    private EntityManagerFactory emf;

    public AnsattDAO() {
        emf = Persistence.createEntityManagerFactory("pu");
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

    public void exit() {
        emf.close();
    }

    // Hent liste av alle ansatte fra gitt avdeling
    public List<Ansatt> hentAlleFraAvdeling(Avdeling avdeling) {
        EntityManager em = emf.createEntityManager();
        String jpqlQuery = "SELECT a FROM Ansatt a WHERE a.avdeling = (?1) AND NOT a = (?2) ORDER BY a.id";
        try {
            TypedQuery<Ansatt> query = em.createQuery(jpqlQuery, Ansatt.class);
            List<Ansatt> res = query.setParameter(1, avdeling).setParameter(2, avdeling.sjef()).getResultList();
            res.add(0, avdeling.sjef());
            return res;
        } finally {
            em.close();
        }
    }

    // Legg til ny ansatt
    public Ansatt opprett(Ansatt a) {
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
        return a;
    }

    // Oppdater info om ansatt
    public void oppdater(Ansatt ansatt, String brukernavn, String fornavn, String etternavn, String startdato, String stilling, String lonn) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Ansatt a = em.find(Ansatt.class, ansatt.id());
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
    public void slett(Ansatt ansatt) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Ansatt a = em.find(Ansatt.class, ansatt.id());
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
