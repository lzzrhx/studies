package src;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oblig3")
public class Ansatt {
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
    // TODO: ...
    
    // Getters / setters
    // TODO: ...

    // Stringrepresentasjon av objektet
    public String toString() { return String.format("[Person] id=%d", id); }
}
