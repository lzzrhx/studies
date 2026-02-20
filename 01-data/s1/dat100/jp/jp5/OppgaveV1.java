public class OppgaveV1 {
    public static void main(String[] args) {
        System.out.println("deg   rad     sin     cos");
        System.out.println("- - - - - - - - - - - - - -");
        for (int deg = 0; deg <= 180; deg += 15) {
            double rad = Math.PI * (double)deg / 180.0;
            System.out.printf("%3d  %6.3f  %6.3f  %6.3f%n", deg, rad, Math.sin(rad), Math.cos(rad));
        }
    }
}
