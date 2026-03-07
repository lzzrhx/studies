package src;

public class Program {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" DAT102 - OBLIGATORISK OPPGAVE 3");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();

        uke10oppg4f();
    }

    // Uke 10 - Opggave 4f
    private static void uke10oppg4f() {
        Person a = new Person("a", "basketball", "yoga", "sykling");
        Person b = new Person("b", "yoga", "dataspill");
        Person c = new Person("c", "sykling", "basketball");
        float abMatch = Person.match(a, b);
        float acMatch = Person.match(a, c);
        float bcMatch = Person.match(b, c);
        System.out.printf("Person.match(a, b) = %.2f%n", abMatch);
        System.out.printf("Person.match(a, c) = %.2f%n", acMatch);
        System.out.printf("Person.match(b, c) = %.2f%n", bcMatch);
        System.out.printf("Person a og Person c har best match.%n");
    }

}
