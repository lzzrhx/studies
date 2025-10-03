public class OppgaveB1 {
    public static void main(String[] args) {
        Vare banan = new Vare(1, "Banan", 99);
        Vare eple = new Vare(2, "Eple", 200);

        System.out.println("banan.erBilligereEnn(eple): " + banan.erBilligereEnn(eple));
        System.out.println("eple.erBilligereEnn(banan): " + eple.erBilligereEnn(banan));

        System.out.println("banan.moms(): " + banan.beregnMoms());
        System.out.println("eple.moms(): " + eple.beregnMoms());

    }
}
