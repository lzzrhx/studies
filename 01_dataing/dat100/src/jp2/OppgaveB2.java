import java.util.Scanner;

public class OppgaveB2 {
    public static void main(String[] args) {
        int a = 5;
        String s = "Hei";
        double b = 4.2;

        System.out.println(a);
        System.out.println(s);
        System.out.println(b);

        System.out.println(s + (a + 3));
        System.out.println("3" + a + s);
        System.out.println(s.split("H")[1]);
        System.out.println(7 / a);
        System.out.println(13 - 2 * 5);

        int c = 1578;
        System.out.println(Integer.toString(c).length());
        System.out.println(s.length());
    }
}
