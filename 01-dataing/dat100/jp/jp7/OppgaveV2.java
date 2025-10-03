import java.util.Scanner;

public class OppgaveV2 {
    public static void main(String[] args) {


        // a)
        Scanner inn = new Scanner(System.in);
        System.out.print("Antall ord: ");
        int n = Integer.parseInt(inn.nextLine());
        String[] ord = new String[n];
        System.out.println("Skriv inn ord: ");
        for (int i = 0; i < n; i++) {
            System.out.print("  " + (i+1) + ": ");
            ord[i] = inn.nextLine().toLowerCase();
        }
        System.out.println();
        System.out.println("Tabell:");
        for (int i = 0; i < n; i++) {
            System.out.println("  " + i + ": " + ord[i]);
        }
        

        // b)
        System.out.println();
        System.out.print("Skriv inn mønster: ");
        String pattern = inn.nextLine().toLowerCase();
        int ant = 0;
        for (int i = 0; i < n; i++) {
            if (pattern != "" && ord[i].contains(pattern)) {
                ant++;
            }
        }
        System.out.println(ant + " ord fra tabellen inneholder mønsteret \"" + pattern + "\".");
        

        // c)
        System.out.println();

        for (int i = 0; i < n; i++) {
            int len = ord[i].length();
            System.out.println(len == 1 ? ord[i] : (len % 2 == 0 ? ord[i].substring(len / 2 - 1, len / 2 + 1) : ord[i].substring(len / 2 - 1, len / 2 + 2) ));
        }
        inn.close();

        // d)
        baklengs("abcdefgh");

        // e)
        System.out.println();
        System.out.println("Første ord (lexicographically): " + forste(ord));

        // f)
        String a = "abc";
        String b = "acb";
        System.out.println();
        System.out.println("compareTo(\"" + a + "\", \"" + b + "\"): " + compareTo(a, b));
        System.out.println("\"" + a + "\".compareToIgnoreCase(\"" + b + "\"): " + a.compareToIgnoreCase(b));

    }

    private static void baklengs(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result += s.charAt(s.length()-1-i);
        }
        System.out.println("\"" + s + "\" baklengs er \"" + result + "\"");
    }

    private static String forste(String[] tab) {
        String result = tab[0];
        for (int i = 1; i < tab.length; i++) {
            if (tab[i].compareToIgnoreCase(result) < 0) {
                result = tab[i];
            }
        }
        return result;
    }

    private static int compareTo(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        if (!a.equals(b)) {
            for (int i = 0; i < a.length(); i++) {
                int diff = a.charAt(i) - b.charAt(i);
                if (diff != 0) {
                    return diff;
                }
            }
        }
        return 0;
    }

}
