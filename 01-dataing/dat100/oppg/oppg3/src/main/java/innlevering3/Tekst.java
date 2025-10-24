package innlevering3;
import innlevering3.HtmlBlogg;

public class Tekst extends Innlegg {

    // Objektvariabler
    private String tekst;

    // Getter for tekst
    public String tekst() {
        return tekst;
    }

    // Konstruktør
    public Tekst(int id, String bruker, String dato, String tekst) {
        this(id, bruker, dato, 0, tekst);
    }
    
    // Konstruktør
    public Tekst(int id, String bruker, String dato, int likes, String tekst) {
        super(id, bruker, dato, likes);
        this.tekst = tekst;
    }

    // Setter for tekst
    public void tekst(String tekst) {
        this.tekst = tekst;
    }

    // Stringrepresentasjon av objektet
    public String toString() {
        return "TEKST\n" + super.toString() + tekst + "\n";
    }

    // HTML-representasjon av objektet
    public String toHTML(int indent) {
        String result = super.toHTML(indent);
        result += HtmlBlogg.htmlLine(indent, "<p>" + tekst + "</p>");
        return result; 
    }
}
