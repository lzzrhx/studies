import java.util.Scanner;

public class OppgaveB3 {
    public static void main(String args[]) {
        
        Scanner in = new Scanner(System.in);
        System.out.print("Brukernavn: ");
        String brukernavn = in.nextLine();
        System.out.print("Passord: ");
        String passord = in.nextLine();
        in.close();
        
        String riktigBrukernavn = "user";
        String riktigPassord = "pass";
        if (riktigBrukernavn.equals(brukernavn) && riktigPassord.equals(passord)) {
            System.out.println("Riktig brukernavn og passord! :)");
        } else {
            System.out.println("Feil brukernavn og passord! :(");
        }

    }
}
