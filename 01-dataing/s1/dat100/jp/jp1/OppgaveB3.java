import java.util.Scanner;

public class OppgaveB3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Beregn sekunder -> timer, minutter og sekunder: ");
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.print("Sekunder = ");
        int sekunder = in.nextInt();
        System.out.println(sekunderTilTimerMinutterSekunder(sekunder));
        in.close();
    }

    private static String sekunderTilTimerMinutterSekunder(int sekunder) {
        int timer = sekunder / 3600;
        int minutter = sekunder % 3600 / 60;
        sekunder = sekunder % 60;
        return timer + " timer, " + minutter + " minutter og " + sekunder + " sekunder";
    }
}
