package innlevering3;

import java.io.IOException;
import java.net.ServerSocket;

public class Program {
    public static final int SERVERPORT = 8080;
    //public static String SERVER = "localhost";
    public static final int N = 99;

    public static void main(String[] args) {

        // Testing classes
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(" INNLEVERING 3");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        Tekst i1 = new Tekst(1, "bruker", "23-10", "tekst");
        Bilde i2 = new Bilde(2, "bruker", "23-10", "bildetekst", "url.com");
        System.out.println(i1);
        System.out.println(i2);
        Blogg blogg = new Blogg(10);
        blogg.leggTil(i1);
        blogg.leggTilUtvid(i2);
        Blogg bloggLest = LesBlogg.les(System.getProperty("user.dir") + "/src/test/java/innlevering3/tests/", "bloggkorrekt.dat");
        System.out.println(bloggLest.samling().length);
        System.out.println(bloggLest.toString());
        
        // HTMLBlogg setup
        Tekst i3 = new Tekst(
            1, 
            "Sven-Olai", 
            "23-10",
            "Lars, hva er status for den siste obligatoriske innleveringen?"
        );
        Bilde i4 = new Bilde(
            2, 
            "Lars", 
            "24-10",
            "Ser bra ut! - har lagt ved output-eksempel fra enhetstester",
            "https://lmkr.github.io/junitrun.png"
        );
        i3.like();
        i3.like();
        i4.like();
        HtmlBlogg htmlBlogg = new HtmlBlogg(10);
        htmlBlogg.leggTilUtvid(i3);
        htmlBlogg.leggTilUtvid(i4);

        // Start server
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(" SERVER STARTING");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("TCP server starting # " + SERVERPORT);
        try (ServerSocket welcomeSocket = new ServerSocket(SERVERPORT)) {
            BloggServer server = new BloggServer(welcomeSocket);
            int n = N;
            while (n>0) {
                server.process(htmlBlogg);
                n--;
            }
        } catch (IOException ex) {
            System.out.println("TCP server: " + ex.getMessage());
            ex.printStackTrace();
        } 
        System.out.println("TCP Server shutting down");
    }
}
