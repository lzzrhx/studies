package kap7;
import java.util.Scanner;

public class Filter {
    public static void main(String[] args) {
        String filter = args[0];
        Scanner stdin = new Scanner(System.in);
        String linje;
        while (stdin.hasNextLine()) {
            linje = stdin.nextLine();
            if (linje.matches("(.)*" + filter + "(.)*")) {
                System.out.println(linje);
            }
        }
    }
}
