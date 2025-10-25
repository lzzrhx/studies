public class Oppgave1 {
    public static void main(String[] args) {
        int[] tab = {1,2,3,4,5,6};
        System.out.print("[ ");
        for (int x : tab) {
            System.out.print(x + " ");
        }
        System.out.println("]");
        for (int i = 0; i < tab.length; i++) {
            tab[i] += 1;
        }
        System.out.print("[ ");
        for (int x : tab) {
            System.out.print(x + " ");
        }
        System.out.println("]");
    }
}
