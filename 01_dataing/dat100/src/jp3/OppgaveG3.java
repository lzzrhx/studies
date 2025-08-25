public class OppgaveG3 {
    public static void main(String args[]) {
        for (int i = 1; i <= 20; i++) {
            //delB(i);
            delC(i);
        }
    }
    
    private static void delB(int i) {
        System.out.println(switch (i) {
            case 1 -> "A";
            case 2 -> "B";
            default -> "C";
        });
    }

    private static void delC(int i) {
        String result = "C";
        if (i == 1) {
            result = "A";
        } else if (i == 2) {
            result = "B";
        }
        System.out.println(result);
    }
}
