public class OppgaveB1 {
    public static void main(String[] args) {
        final int SETER = 8;
        final int RADER = 6;
        final int TOTAL = SETER * RADER;
        boolean[][] aud = new boolean[RADER][SETER];

        // c)
        System.out.println("tildel: " + tildel(aud));
        System.out.println("tildel: " + tildel(aud));
        System.out.println("tildel: " + tildel(aud));
        System.out.println("tildel: " + tildel(aud));
        System.out.println("tildel: " + tildel(aud));

        // a)
        int ledige = ledige(aud);
        System.out.println("ledige: " + ledige + " / " + TOTAL);

        // b)
        System.out.println("prosent ledige: " + prosent(ledige, TOTAL));

        // d)
        System.out.println("finnes ledig: " + ledig(aud));
        
        // d)
        System.out.println("smittevern: " + smittevern(aud));
    }

    private static int ledige(boolean[][] aud) {
        int count = 0;
        for (int i = 0; i < aud.length; i++) {
            for (int j = 0; j < aud[i].length; j++) {
                if (!aud[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static float prosent(int n, int m) {
        return (float)n / (float)m * 100f;
    }
    
    private static String tildel(boolean[][] aud) {
        for (int i = aud.length - 1; i >= 0; i--) {
            for (int j = 0; j < aud[i].length; j++) {
                if (!aud[i][j]) {
                    aud[i][j] = true;
                    return i + ":" + j;
                }
            }
        }
        return "err!";
    }

    private static boolean ledig(boolean[][] aud) {
        for (boolean[] rad: aud) {
            for (boolean sete: rad) {
                if (!sete) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean smittevern(boolean[][] aud) {
        for (int i = 0; i < aud.length; i++) {
            int count = 2;
            for (int j = 0; j < aud[i].length; j++) {
                if (aud[i][j]) {
                    if (count < 2) { return false; }
                    count = 0;
                } else {
                    count++;
                }
            }
        }
        return true;
    }
}
