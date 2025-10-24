package innlevering3;
import innlevering3.HtmlBlogg;

public abstract class Innlegg {

    // Klassevariabler
    //private static int num = 0;

    // Objektvariabler
    private int id;
    private String bruker;
    private String dato;
    private int likes;

    // Konstruktør
    public Innlegg(int id, String bruker, String dato) {
        this(id, bruker, dato, 0);
    }

    // Konstruktør
    public Innlegg(int id, String bruker, String dato, int likes) {
        //Innlegg.num++;
        //this.id = Innlegg.num;
        this.id = id;
        this.bruker = bruker;
        this.dato = dato;
        this.likes = likes;
    }

    // Getter for id
    public int id() {
        return id;
    }

    // Getter for bruker
    public String bruker() {
        return bruker;
    }

    // Setter for bruker
    public void bruker(String bruker) {
        this.bruker = bruker;
    }

    // Getter for dato
    public String dato() {
        return dato;
    }

    // Setter for dato
    public void dato(String dato) {
        this.dato = dato;
    }

    // Getter for likes
    public int likes() {
        return likes;
    }

    // Legg til like
    public void like() {
        likes++;
    }

    // Sjekk om ett innlegg er likt ett annet innlegg
    public boolean equals(Innlegg innlegg) {
        return this.id == innlegg.id;
    }

    // Stringrepresentasjon av objektet
    public String toString() {
        return id + "\n" + bruker + "\n" + dato + "\n" + likes + "\n";
    }

    // HTML-representasjon av objektet
    public String toHTML(int indent) {
        return HtmlBlogg.htmlLine(indent, "<h2>" + bruker + "@" + dato + " [" + likes + "]</h2>");
    }
}
