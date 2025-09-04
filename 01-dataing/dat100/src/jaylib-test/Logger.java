import java.util.ArrayList;

public class Logger {

    private static ArrayList <String> log = new ArrayList<String>();

    public static void log(String message) {
        log.add(message);
        System.out.println(message);
    }
}
