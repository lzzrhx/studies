package src;

public class Person {
    private Integer id;
    private String navn;
    public Integer id() { return id; }
    public void id(int id) { this.id = id; }
    public String navn() { return navn; }
    public void setNavn(String navn) { this.navn = navn; }
    public String toString() { return String.format("[Person] id: %d, navn: %s", id, navn); }
    public Person(int id, String navn) {
        this.id = id;
        this.navn = navn;
    }
}
