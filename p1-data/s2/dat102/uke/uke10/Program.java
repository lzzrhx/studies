public class Program {

    public static void main(String[] args) {
        oppg1();
        System.out.println();
        oppg2();
    }

    // Oppgave 1
    private static void oppg1() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" UKE 10, OPPGAVE 1");
        System.out.println("--------------------------------------------------------------------------------");

        Node<Character> a = new Node<>('A');
        Node<Character> b = new Node<>('B');
        Node<Character> c = new Node<>('C');
        
        // a)
        a.neste = b;
        b.neste = c;
        System.out.printf("a)%n");
        printLenke(a);

        System.out.println();

        // b)
        a.neste = c;
        b.neste = null;
        System.out.printf("b)%n");
        printLenke(a);
        
        System.out.println();

        // c)
        Node<Character> d = new Node<>('D');
        a.neste = d;
        d.neste = c;
        System.out.printf("c)%n");
        printLenke(a);
        
        System.out.println();

        // d)
        Node<Character> e = new Node<>('E');
        c.neste = e;
        System.out.printf("d)%n");
        printLenke(a);
        
        System.out.println();

        // e)
        System.out.printf("e)%n");
        System.out.printf("antallNoderILenke(a) = %d%n", antallNoderILenke(a));
        
        System.out.println();

        // f)
        System.out.printf("f)%n");
        System.out.printf("lenkeInneholder('C') = %b%n", lenkeInneholder(a, 'C'));
        System.out.printf("lenkeInneholder('F') = %b%n", lenkeInneholder(a, 'F'));
    }
    
    private static <T> void printLenke(Node<T> node) {
        while (node != null) {
            System.out.printf("%s → ", node.data);
            node = node.neste;
        }
        System.out.println("null");
    }

    private static <T> int antallNoderILenke(Node<T> node) {
        int n = 0;
        while (node != null) {
            n += 1;
            node = node.neste;
        }
        return n;
    }

    private static boolean lenkeInneholder(Node<Character> node, Character c) {
        while (node != null) {
            if (node.data == c) { return true; }
            node = node.neste;
        }
        return false;
    }
    
    // Oppgave 2
    private static void oppg2() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" UKE 10, OPPGAVE 2");
        System.out.println("--------------------------------------------------------------------------------");

        // a)
        System.out.printf("a)%n");
        Node<Integer> node = new Node<>(1);
        node.neste = new Node<>(2);
        node.neste.neste = new Node<>(3);
        node.neste.neste.neste = new Node<>(4);
        printLenke(node);

        // b)
        System.out.println();
        System.out.printf("b)%n");
        System.out.printf("lenkeInneholderRekursiv(node, 3) = %b%n", lenkeInneholderRekursiv(node, 3));
        System.out.printf("lenkeInneholderRekursiv(node, 5) = %b%n", lenkeInneholderRekursiv(node, 5));
        
        // c)
        System.out.println();
        System.out.printf("c)%n");
        printFremlengsRekursiv(node);
        System.out.println();
        
        // d)
        System.out.println();
        System.out.printf("d)%n");
        printBaklengsRekursiv(node);
        System.out.println();
        
        // e)
        System.out.println();
        System.out.printf("e)%n");
        printBaklengsMedStabel(node);
        System.out.println();
        
        // f)
        System.out.println();
        System.out.printf("f)%n");
        Node<Integer> tmp = new Node<>(3);
        tmp.neste = node;
        node = tmp;
        tmp = null;
        printFremlengsRekursiv(node);
        System.out.println();
        System.out.printf("antallAvIterativ(node, 2) = %d%n", antallAvIterativ(node, 2));
        System.out.printf("antallAvIterativ(node, 3) = %d%n", antallAvIterativ(node, 3));
        System.out.printf("antallAvIterativ(node, 5) = %d%n", antallAvIterativ(node, 5));
        
        // g)
        System.out.println();
        System.out.printf("g)%n");
        printFremlengsRekursiv(node);
        System.out.println();
        System.out.printf("antallAvRekursiv(node, 2) = %d%n", antallAvRekursiv(node, 2));
        System.out.printf("antallAvRekursiv(node, 3) = %d%n", antallAvRekursiv(node, 3));
        System.out.printf("antallAvRekursiv(node, 5) = %d%n", antallAvRekursiv(node, 5));
    }

    private static boolean lenkeInneholderRekursiv(Node<Integer> node, Integer n) {
        return (node.data == n ? true : (node.neste == null ? false : lenkeInneholderRekursiv(node.neste, n)));
    }

    private static <T> void printFremlengsRekursiv(Node<T> node) {
        System.out.print(node.data + " ");
        if (node.neste != null) { printFremlengsRekursiv(node.neste); }
    }

    private static <T> void printBaklengsRekursiv(Node<T> node) {
        if (node.neste != null) { printBaklengsRekursiv(node.neste); }
        System.out.print(node.data + " ");
    }
    
    private static <T> void printBaklengsMedStabel(Node<T> node) {
        StackADT<T> stack  = new Stack<>();
        while (node != null) {
            stack.push(node.data);
            node = node.neste;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static int antallAvIterativ(Node<Integer> node, Integer n) {
        int res = 0;
        while (node != null) {
            if (node.data == n) { res += 1; }
            node = node.neste;
        }
        return res;
    }
    
    private static int antallAvRekursiv(Node<Integer> node, Integer n) {
        return (node.data == n ? 1 : 0) + (node.neste != null ? antallAvRekursiv(node.neste, n) : 0);
    }

    // Oppgave 3
    // a) n^2
    // b) 0.016 / (100 * 100) = 0.0000016
    //    0.0000016 * 1000 * 1000 = 1.6
    // c) n
    // d) 0.012 / 10000 = 0.0000012
    //    1000000 * 0.0000012 = 1.2
    // e)
    // i.)  n + n * n / 2     --> O(n^2)
    // ii.)
    /*
    private static void oppg3e() {
        final int n = 100;
        int[] tab = new int[n];
        int[] sumTab = new int[n];
        Random tilf = new Random();
        int sum = 0;
        for(int i = 0; i < n; i++){
            int rnd = tilf.nextInt(100);
            sum += rnd;
            tab[i] = rnd;
            sumTab[i] = sum;
        }
    }
    */

}
