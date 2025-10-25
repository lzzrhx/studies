import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Oppgave1 {

    // Konstanter
    private static final String DIR = System.getProperty("user.dir") + "/";
    private static final int MAX_TRIES = 3;
    private static final boolean USE_BUFFERED = true;

    // Entry-point
    static public void main(String[] args) {
        lesFil(DIR);
    }

    // Lesing av fil
    private static void lesFil(String dir) {
        int tries = 0;
        boolean success = false;
        while (tries < MAX_TRIES && !success) {
            String filnavn = JOptionPane.showInputDialog("Filnavn i mappen " + dir);
            // Prøv å lese fil
            try {
                int lineno = 1;
                String line;
                System.out.printf("%s%n", (dir + filnavn));
                // Printing av filen med bruk av BufferedReader objekt
                if (USE_BUFFERED) {
                    BufferedReader reader = new BufferedReader(new FileReader(dir + filnavn));
                    while ((line = reader.readLine()) != null) {
                        printLine(lineno, line);
                        lineno++;
                    }
                    reader.close();
                }
                // Printing av filen med bruk av Scanner objekt
                else {
                    Scanner reader = new Scanner(new File(dir + filnavn));
                    while (reader.hasNextLine()) {
                        line = reader.nextLine();
                        printLine(lineno, line);
                        lineno++;
                    }
                    reader.close();
                }
                success = true;
            }
            // Fang unntak
            catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "ERR! Filen \"" + filnavn + "\" finnes ikke! \n" + e.getMessage());
            }
            // Fang unntak
            catch (IOException e) {
                JOptionPane.showMessageDialog(null, "ERR! IO feil! \n" + e.getMessage());
            }
            tries++;
        }
    }

    // Printing av linje med linjenr
    private static void printLine(int lineno, String line) {
        System.out.printf("%2d  %s%n", lineno, line);
    }
}
