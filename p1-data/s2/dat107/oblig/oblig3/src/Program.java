package src;

public class Program {
    private static final AnsattCrud ansattCrud = new AnsattCrud();

    public static void main(String[] args) {
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" DAT107 - OBLIGATORISK OPPGAVE 3");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();

        printAnsatte();
        System.out.println();

        //System.out.println("ansattCrud.opprett(new Ansatt()");
        //personCrud.lagrePerson(new Person(1004, "Mikke"));
        //printPersoner();
        //System.out.println();
        
        //System.out.println("personCrud.oppdaterPerson(1004, \"Mikke Mus\")");
        //personCrud.oppdaterPerson(1004, "Mikke Mus");
        //printPersoner();
        //System.out.println();
        
        //System.out.println("personCrud.slettPerson(1004)");
        //personCrud.slettPerson(1004);
        //printPersoner();
        //System.out.println();
    }

    private static void printAnsatte() {
        System.out.println("Ansatte i tabellen:");
        ansattCrud.hentAlle().forEach(System.out::println);
    }
}
