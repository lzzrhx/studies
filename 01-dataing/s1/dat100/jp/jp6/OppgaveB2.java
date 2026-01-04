// java -cp .:../../lib/easygraphics.jar OppgaveB2
public class OppgaveB2 extends EasyGraphics {
    final int NUM_V = 3;
    final int NUM_H = 10;
    final int MID = 1;
    final int MARGIN = 10;
    final int WIDTH = 800;
    final int RADIUS = (WIDTH - MARGIN * 2) / NUM_H / 2;
    final int HEIGHT = RADIUS * 2 * NUM_V + MARGIN * 2;

    public static void main(String[] args) {
        launch(args);
    }

    public void run() {
        int[][] terreng = { 
                { 0, 1, 0, 1, 2, 3, 4, 5, 6, 8 }, 
                { 0, 1, 1, 2, 3, 4, 5, 7, 8, 9 },
                { 0, 0, 1, 2, 3, 5, 6, 7, 9, 10 }
            };
        makeWindow("FLOODING", WIDTH, HEIGHT);
        while (true) {
            visualiser(terreng);
        }
    }

    public void visualiser(int[][] terreng) {
        System.out.println("Angi havhøyde i tegnevinduet ...");
        int hav = Integer.parseInt(getText("Angi havhøyde:"));
        for (int i = 0; i < terreng.length; i++) {
            for (int j = 0; j < terreng[i].length; j++) {
                if (terreng[i][j] <= hav) {
                    setColor(0,0,255);
                } else if (terreng[i][j] <= hav + MID) {
                    setColor(255,140,0);
                } else {
                    setColor(222,184,135);
                }
                fillCircle(MARGIN + RADIUS + RADIUS * 2 * j, MARGIN + RADIUS + RADIUS * 2 * i, RADIUS);
            }
        }
    }
}
