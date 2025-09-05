import java.util.ArrayList;

// Class for logging messages and errors
public class Logger {

    private static ArrayList <String> entries = new ArrayList<String>();

    // Add message to the log
    public static void log(String message) {
        entries.add(message);
        System.out.println(message);
    }
}
