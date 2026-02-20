import javax.swing.SwingUtilities;

public class Oppgave2 {

    public static void main(String[] args) {
        
        // Start Swing UI thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MyBrowser();
            }
        });

    }

}
