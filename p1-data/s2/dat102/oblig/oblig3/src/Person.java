package src;

public class Person {

    // Objektvariabler
    private String navn;
    private MengdeADT<String> hobbyer = new TabellMengde<String>();
    
    // Konstruktør
    public Person(String navn, String ... hobbyer) {
        this.navn = navn;
        for (String hobby : hobbyer) {
            this.hobbyer.leggTil(hobby);
        }
    }

    // Sjekker om Person a og Person b har matchende hobbyer-
    // Returnerer en verdi mellom 0 og 1, der 0 er dårlig match (ingen felles hobbyer)
    // og 1 er god match med alle hobbyer til felles.
    public static float match(Person a, Person b) {
        int nA = a.hobbyer.antallElementer();
        int nB = b.hobbyer.antallElementer();
        int nMax = nA > nB ? nA : nB;
        if (nMax == 0) { return 1f; }
        int nFelles = (a.hobbyer.snitt(b.hobbyer)).antallElementer();
        return (float)nFelles / (float)nMax;
    }

}
