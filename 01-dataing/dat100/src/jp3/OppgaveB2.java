import static javax.swing.JOptionPane.*;

public class OppgaveB2 {
    public static void main(String args[]) {
        for (int i = 0; i < 5; i++) {
            int tall = Integer.parseInt(showInputDialog("Gi et tall:"));
            System.out.println(tall);
        }
    }
}
