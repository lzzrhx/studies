package src;

//import jakarta.persistence.Persistence;
//import java.util.List;
//import java.util.Map;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
//import jakarta.persistence.TypedQuery;

public class Program {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public static void main(String[] args) {
        System.out.println("test");
        Person p = finnPersonMedId(1001);
        System.out.println(p);
    }
    private static Person finnPersonMedId(int id) {

		System.out.println("Kobler til database...");
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Person.class, id);
        } finally {
            em.close();
        }
    }
}
