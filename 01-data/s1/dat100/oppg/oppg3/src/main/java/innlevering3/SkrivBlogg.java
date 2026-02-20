package innlevering3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SkrivBlogg {
    public static boolean skriv(Blogg blogg, String mappe, String fil){
        try {
            PrintWriter writer = new PrintWriter(mappe+fil);
            writer.print(blogg);
            writer.close();
            return true;
        }
        catch(FileNotFoundException e) {
            System.out.println("ERR! Fil ikke funnet!");
            return false;
        }
    }
}
