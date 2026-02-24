import java.util.Scanner;

public class OppgaveG3 {
    public static void main(String[] args) {
        //int dn = Integer.parseInt(args[0]);
        Scanner in = new Scanner(System.in);
        System.out.println("Tast inn fire tall.");
        System.out.print("1: ");
        int n1 = in.nextInt();
        System.out.print("2: ");
        int n2 = in.nextInt();
        System.out.print("3: ");
        int n3 = in.nextInt();
        System.out.print("4: ");
        int n4 = in.nextInt();
        in.close();

        int nMin = Math.min(Math.min(n1, n2), Math.min(n3, n4));
        
        System.out.println("Det minste tallet av de fire er " + nMin + ".");
    }
}
