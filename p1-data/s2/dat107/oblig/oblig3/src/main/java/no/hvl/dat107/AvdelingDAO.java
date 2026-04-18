package no.hvl.dat107;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AvdelingDAO {
    private EntityManagerFactory emf;

    AvdelingDAO() {
        emf = Persistence.createEntityManagerFactory("pu");
    }

    public void exit() {
        emf.close();
    }

    // Hent liste av avdelinger
    public List<Avdeling> hentFiltrertListe(Integer id, String navn, Ansatt sjef) {
        EntityManager em = emf.createEntityManager();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT a FROM Avdeling a");
        boolean chained = false;
        if (id != null || navn != null || sjef != null) { sb.append("WHERE"); }
        if (id != null) {
            sb.append(" a.id = ");
            sb.append(id);
            chained = true;
        }
        if (navn != null) {
            if (chained) {
                sb.append(" AND");
            }
            sb.append(" UPPER(a.navn) LIKE '%");
            sb.append(navn.toUpperCase());
            sb.append("%'");
            chained = true;
        }
        sb.append(" ORDER BY a.id");
        String jpqlQuery = sb.toString();
        try {
            TypedQuery<Avdeling> query = em.createQuery(jpqlQuery, Avdeling.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    // Hent liste av alle avdelinger
    public List<Avdeling> hentAlle() {
        EntityManager em = emf.createEntityManager();
        String jpqlQuery = "SELECT a FROM Avdeling a ORDER BY a.id";
        try {
            TypedQuery<Avdeling> query = em.createQuery(jpqlQuery, Avdeling.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}
