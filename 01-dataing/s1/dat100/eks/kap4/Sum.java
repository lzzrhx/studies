package kap4;

public class Sum {
    
    public static void main(String[] args) {
        int svar = sum(2, 6);
        System.out.println("Sum fom 2 tom 6 = " + svar);
    }

    private static int sum(int fra, int til) {
        return (fra + til) * (til - fra + 1) / 2;
    }
}
