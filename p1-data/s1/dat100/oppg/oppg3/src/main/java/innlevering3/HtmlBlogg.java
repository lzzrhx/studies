package innlevering3;

public class HtmlBlogg extends Blogg {

    // Konstruktør
    public HtmlBlogg() {
        super();
    }
    
    // Konstruktør
    public HtmlBlogg(int lengde) {
        super(lengde);
    }

    private static String HTMLPREFIX = 
            "<html>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n\t</head>\n\t<body>\n";

    private static String HTMLPOSTFIX = 
            "\t</body>\n</html>";

    public String toString() {
        int indent = 0;
        String result = "";
        result += htmlLine(indent, "<html>");
        indent++;
        result += htmlLine(indent, "<head>");
        indent++;
        result += htmlLine(indent, "<title>DAT100 Blogg</title>");
        indent--;
        result += htmlLine(indent, "</head>");
        result += htmlLine(indent, "<body>");
        indent++;
        for (int i = 0; i < antall(); i++) {
            result += samling()[i].toHTML(indent);
            if (i < antall()-1) {
                result += htmlLine(indent, "<hr>");
            }
        }
        indent--;
        result += htmlLine(indent, "</body>");
        indent--;
        result += htmlLine(indent, "</html>");
        return result;
    }

    public static String htmlLine(int indent, String line) {
        return "    ".repeat(indent) + line + "\n";
    }
}
