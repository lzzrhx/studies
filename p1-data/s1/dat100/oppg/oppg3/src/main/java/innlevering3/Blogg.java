package innlevering3;

import java.util.ArrayList;
import java.util.List;

public class Blogg {

    // Objektvariabler
    private int antall;
    private Innlegg[] samling;

    // Konstruktør
    public Blogg() {
        this(20);
    }

    // Konstruktør
    public Blogg(int lengde) {
        samling = new Innlegg[lengde];
    }

    // Getter for antall
    public int antall() {
        return antall;
    }

    // Getter for tabell
    public Innlegg[] samling() {
        return samling;
    }

    // Finn innlegg
    public int finn(Innlegg innlegg) {
        for (int i = 0; i < antall; i++) {
            if (samling[i].equals(innlegg)) {
                return i;
            }
        }
        return -1;
    }

    // Sjekk om innlegg finnes
    public boolean finnes(Innlegg innlegg) {
        for (int i = 0; i < antall; i++) {
            if (samling[i].equals(innlegg)) {
                return true;
            }
        }
        return false;
    }

    // Sjekk om det er ledig plass
    public boolean ledig() {
        return antall < samling.length;
    }

    // Utvid samlingen til dobbel størrelse
    public void utvid() {
        Innlegg[] nySamling = new Innlegg[samling.length * 2];
        for (int i = 0; i < samling.length; i++) {
            nySamling[i] = samling[i];
        }
        samling = nySamling;
    }

    // Legg til innlegg i samlingen
    public boolean leggTil(Innlegg innlegg) {
        if (ledig() && !finnes(innlegg)) {
            samling[antall] = innlegg;
            antall++;
            return true;
        }
        return false;
    }

    // Prøv å legg til nytt innlegg, men utvid hvis det ikke er plass
    public boolean leggTilUtvid(Innlegg innlegg) {
        if (!finnes(innlegg)) {
            if (!ledig()) {
                utvid();
            }
            samling[antall] = innlegg;
            antall++;
            return true;
        }
        return false;
    }

    // Stringrepresentasjon av klassen
    public String toString() {
        String result = antall + "\n";
        for (int i = 0; i < antall; i++) {
            result += samling[i];
        }
        return result;
    }

    // Slett innlegg fra samlingen
    public boolean slett(Innlegg innlegg) {
        for (int i = 0; i < antall; i++) {
            if (samling[i].equals(innlegg)) {
                antall--;
                samling[i] = samling[antall];
                samling[antall] = null;
                return true;
            }
        }
        return false;
    }

    // Søk etter innlegg i samlingen
    public int[] sok(String ord) {
        List<Integer> resultat = new ArrayList<>();
        for (int i = 0; i < antall; i++) {
            if (samling[i] instanceof Tekst) {
                Tekst tekst = (Tekst)samling[i];
                if (tekst.tekst().contains(ord)) {
                    resultat.add(samling[i].id());
                }
            }
            else if (samling[i] instanceof Bilde) {
                Bilde bilde = (Bilde)samling[i];
                if (bilde.tekst().contains(ord)) {
                    resultat.add(samling[i].id());
                }
            }
        }
        int[] resultatTabell = new int[resultat.size()];
        for (int i = 0; i < resultat.size(); i++) {
            resultatTabell[i] = resultat.get(i);
        }
        return resultatTabell;
    }

}
