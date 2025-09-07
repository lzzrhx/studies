package tdee;

import java.util.ArrayList;

// Logging av meldinger og feilmeldinger
public class Logger {

    private static ArrayList <String> entries = new ArrayList<String>();

    // Legg til ny melding i loggen
    public static void log(String message) {
        entries.add(message);
        System.out.println(message);
    }
}
