package kap7;
import java.io.*;

public class SkrivNavneliste {
    public static void main(String[] args) throws Exception{
            String filnavn = "navn.txt";
            PrintWriter skriver = new PrintWriter(filnavn);
            String[] navnTab = {"Jo", "Jan", "June", "Jenny"};
            for (int i = 0; i < navnTab.length; i++) {
                skriver.println(navnTab[i]);
            }
            skriver.close();
        }
}
