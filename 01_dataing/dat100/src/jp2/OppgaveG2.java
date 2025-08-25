import java.util.Scanner;

public class OppgaveG2 {
    public static void main(String[] args) {
        //int dn = Integer.parseInt(args[0]);
        Scanner in = new Scanner(System.in);
        System.out.print("Tast inn ukedag (1-7): ");
        int dn = in.nextInt();
        in.close();

        String dag = switch (dn) {
            case 1 -> "Mandag";
            case 2 -> "Tirsdag";
            case 3 -> "Onsdag";
            case 4 -> "Torsdag";
            case 5 -> "Fredag";
            case 6 -> "Lørdag";
            case 7 -> "Søndag";
            default -> "Ulovlig nummer";
        };
        
        System.out.println(dn + " = " + dag);
    }
}
