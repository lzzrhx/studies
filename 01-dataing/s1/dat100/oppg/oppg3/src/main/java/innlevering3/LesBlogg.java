package innlevering3;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

public class LesBlogg {

    public static Blogg les(String mappe, String filnavn) {
        try {
            File fil = new File(mappe+filnavn);
            Scanner scanner = new Scanner(fil);
            String linje = null;
            Blogg blogg = null;
            String[] innhold = null;
            int i = 0;
            while (scanner.hasNextLine()) {
                linje = scanner.nextLine();
                if (blogg == null) {
                    blogg = new Blogg(Integer.parseInt(linje));
                }
                else if (linje.equals("TEKST") || linje.equals("BILDE")) {
                    leggTil(blogg, innhold);
                    innhold = new String[linje.equals("BILDE") ? 7 : 6];
                    i = 0;
                }
                if (innhold != null && i < innhold.length) {
                    innhold[i] = linje;
                    i++;
                }
            }
            leggTil(blogg, innhold);
            scanner.close();
            return blogg;
        }
        catch (FileNotFoundException e) {
            System.out.println("ERR! Fil ikke funnet! (" + mappe + filnavn + ")");
            return null;
        }
        catch (IOException e) {
            System.out.println("ERR! IO feil!");
            return null;
        }
    }

    private static void leggTil(Blogg blogg, String[] innhold) {
        if (innhold != null) {
            if (innhold[0].equals("TEKST")) {
                blogg.leggTil(new Tekst(Integer.parseInt(innhold[1]), innhold[2], innhold[3], Integer.parseInt(innhold[4]), innhold[5]));
            }
            else if (innhold[0].equals("BILDE")) {
                blogg.leggTil(new Bilde(Integer.parseInt(innhold[1]), innhold[2], innhold[3], Integer.parseInt(innhold[4]), innhold[5], innhold[6]));
            }
        }
    }
}
