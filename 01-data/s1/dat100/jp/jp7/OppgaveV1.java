public class OppgaveV1 {
    public static void main(String[] args) {
        int[][] tab = { 
            { 1,  2,  3,  4,  5},
            { 6,  7,  8,  9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25},
        };
        skrivUt(tab);
    }

    // Skriv ut to-dimensjonall tabell av heltall ved bruk av 1 løkke
    private static void skrivUt(int[][] tab) {
        for (int i = 0; i < tab.length * tab[0].length; i++) {
            System.out.printf("%2d" + (i % tab[0].length == tab[0].length-1 ? "%n" : " "), tab[i / tab[0].length][i % tab[0].length]);
        }
    }

}
