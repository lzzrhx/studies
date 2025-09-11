import javax.swing.JOptionPane;

public class OppgaveG2 {
    public static void main(String[] args) {
        System.out.println("OppgaveG2");
        int b = lesHeltallAlt(" Bredde: ");
        int h = lesHeltallAlt(" Høyde: ");
        System.out.println(" b: " + b);
        System.out.println(" h: " + h);
        System.out.println(" areal(b,h): " + areal(b,h));
    }

    private static int areal(int b, int h) {
        return b * h;
    }

    private static int lesHeltall(String message) {
        return Integer.parseInt(JOptionPane.showInputDialog(message));
    }

    private static int lesHeltallAlt(String message) {
        int n = 0;
        do {
            n = Integer.parseInt(JOptionPane.showInputDialog(message));
        } while(n < 1);
        return n;
    }
}
