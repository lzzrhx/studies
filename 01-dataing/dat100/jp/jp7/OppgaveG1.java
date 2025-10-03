public class OppgaveG1 {
    public static void main(String[] args) {

        System.out.println("kv3");
        Kvadrat kv3 = new Kvadrat(3);
        System.out.println(kv3.toString());
        kv3.tegn();

        System.out.println();

        System.out.println("kv4");
        Kvadrat kv4 = new Kvadrat(4);
        System.out.println(kv4.toString());
        kv4.tegn();

        System.out.println();

        System.out.println("kv5");
        Kvadrat kv5 = new Kvadrat(5);
        System.out.println(kv5.toString());
        System.out.println("kv5.sum(kv3, kv4): " + kv5.sum(kv3, kv4));
        kv5.tegn();
    }
}
