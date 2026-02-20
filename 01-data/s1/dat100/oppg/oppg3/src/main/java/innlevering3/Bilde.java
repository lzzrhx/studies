package innlevering3;
import innlevering3.HtmlBlogg;

public class Bilde extends Tekst {

    // Objektvariabler
    private String url;

    // Konstruktør
    public Bilde(int id, String bruker, String dato, String tekst, String url) {
        this(id, bruker, dato, 0, tekst, url);
    }

    // Konstruktør
    public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
        super(id, bruker, dato, likes, tekst);
        this.url = url;
    }

    // Getter for url
    public String url() {
        return url;
    }

    // Setter for url
    public void url(String url) {
        this.url = url;
    }

    // Stringrepresentasjon av objektet
    public String toString() {
        return "BILDE\n" + super.id() + "\n" + super.bruker() + "\n" + super.dato() + "\n" + super.likes() + "\n" + super.tekst() + "\n" + url + "\n";
    }

    // HTML-representasjon av objektet
    public String toHTML(int indent) {
        String result = super.toHTML(indent);
        result += HtmlBlogg.htmlLine(indent, "<img src=\"" + url + "\" height=600 width=800>");
        return result; 
    }
}
