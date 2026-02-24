package kap7;
import java.util.Scanner;
import java.io.File;

public class VareSok {
    
    public static void main(String[] args) {
        // varedata.csv format = "Nr;Navn;Pris;Antall"
        //finnVarer("varedata.csv","spade",";")
    }

    private static void finnVarer(String filnavn, String sok, String skilletegn) throws Exception {
        Scanner leser = new Scanner(new File(filnavn));
        String linje;
        if (leser.hasNextLine()) { leser.nextLine(); }
        int i = 0;
        while (leser.hasNextLine()) {
            if (i > 0)
                behandleVarelinje(leser.nextLine(), sok, skilletegn);
            i++;
        }
        leser.close();
    }

    private static void behandleVarelinje(String linje, String sok, String skilletegn) {
        String[] vareTab = linje.split(skilletegn);
        int nr = Integer.parseInt(vareTab[0]);
        String navn = vareTab[1];
        double pris = Double.parseDouble(vareTab[2]);
        int antall = Integer.parseInt(vareTab[3]);
        if (navn.matches("(.)*" + sok + "(.)*"))
            System.out.println("Vare " + nr + ": " + navn + " - pris=" + pris + " antall=" + antall);
    }
}
