package src;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.persistence.NamedQuery;

@Entity
@Table(schema = "ex")
//@NamedQuery(name = "hentAllePersoner", query ="SELECT p FROM Person p ORDER BY p.id")
public class Person {
    // Objektvariabler
    @Id private Integer id;
    private String navn;
    
    // Konstruktører
    public Person() {}
    public Person(Integer id, String navn) {
        this.id = id;
        this.navn = navn;
    }
    
    // Getters / setters
    public Integer id() { return id; }
    public void id(Integer id) { this.id = id; }
    public String navn() { return navn; }
    public void navn(String navn) { this.navn = navn; }

    // Stringrepresentasjon av objektet
    public String toString() { return String.format("[Person] id=%d, navn=%s", id, navn); }
}
