package src;

public class Program {
    private static final PersonCrud personCrud = new PersonCrud();

    public static void main(String[] args) {
        System.out.println();
        System.out.println("EKSEMPEL 2");
        System.out.println(" - - - - - - - - - - -");
        
        printPersoner();
        System.out.println();

        System.out.println("personCrud.lagrePerson(new Person(1004, \"Mikke\"))");
        personCrud.lagrePerson(new Person(1004, "Mikke"));
        printPersoner();
        System.out.println();
        
        System.out.println("personCrud.oppdaterPerson(1004, \"Mikke Mus\")");
        personCrud.oppdaterPerson(1004, "Mikke Mus");
        printPersoner();
        System.out.println();
        
        System.out.println("personCrud.slettPerson(1004)");
        personCrud.slettPerson(1004);
        printPersoner();
        System.out.println();
    }

    private static void printPersoner() {
        System.out.println("Personer i tabellen:");
        personCrud.hentAllePersoner().forEach(System.out::println);
    }
}
