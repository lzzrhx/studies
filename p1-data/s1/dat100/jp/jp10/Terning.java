public class Terning {

    // Konstanter
    public static final int MAX = 6;

    // Objektvariabler
    private int n;

    // Konstruktør
    public Terning() {
        trill();
    }

    // Getter for n
    public int n() {
        return n;
    }

    // Generer tilfeldig tall
    public void trill() {
        n = (int) (Math.random() * MAX + 1);
    }

    // Strengrepresentasjon av objektet
    public String toString() {
        String res = "[";
        res += switch(n) {
            case 6 ->  ":::";
            case 5 ->  ":.:";
            case 4 ->  ": :";
            case 3 ->  "...";
            case 2 ->  " : ";
            case 1 ->  " . ";
            default -> "   ";
        };
        return res + "]";
    }
}
