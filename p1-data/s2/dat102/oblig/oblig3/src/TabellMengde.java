package src;

import java.util.Arrays;

public class TabellMengde<T> implements MengdeADT<T> {
    
    // Klassevariabler
    private static final int DEF_CAP = 10;

    // Objektvariabler
    private T[] tab;
    private int antall;
    private int initial_cap;
    
    // Getter for tabell
    public T[] tab() {
        return tab;
    }

    // Konstruktør (tom)
    public TabellMengde() {
        this(DEF_CAP);
    }

    // Konstruktør
    public TabellMengde(int cap) {
        this.initial_cap = cap;
        clear();
    }

    // Sjekk om mengden er tom
    public boolean erTom() {
        return antall == 0;
    }

    // Sjekk om mengden inneholder et gitt element
    public boolean inneholder(T element) {
        for (int i = 0; i < antall; i++) {
            if (element.equals(tab[i])) {
                return true;
            }
        }
        return false;
    }
    
    // Sjekk om denne mengden er en delmengde av en gitt delmengde
    public boolean erDelmengdeAv(MengdeADT<T> mengde) {
        if (this.antallElementer() > mengde.antallElementer()) {
            return false;
        } else if (!erTom()) {
            for (int i = 0; i < antall; i++) {
                if (!mengde.inneholder(tab[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    // Sjekk om denne mengden er lik en gitt mengde (inneholder nøyaktig samme elementer)
    public boolean erLik(MengdeADT<T> mengde) {
        if (this.antallElementer() != mengde.antallElementer()) {
            return false;
        }
        return this.erDelmengdeAv(mengde);
    }

    // Sjekk om denne mengden er disjunkt med en gitt mengde (inneholder ingen identiske elementer)
    public boolean erDisjunkt(MengdeADT<T> mengde) {
        for (int i = 0; i < antall; i++) {
            if (mengde.inneholder(tab[i])) {
                return false;
            }
        }
        return true;
    }

    // Returnerer snitt av denne mengden og en gitt mengde (felles elementer)
    public MengdeADT<T> snitt(MengdeADT<T> mengde) {
        MengdeADT<T> res = new TabellMengde<T>();
        for (int i = 0; i < antall; i++) {
            if (mengde.inneholder(tab[i])) {
                res.leggTil(tab[i]);
            }
        } 
        return res;
    }

    // Returnerer union av denne mengde og en gitt mengde (alle elementer fra begge mengder)
    public MengdeADT<T> union(MengdeADT<T> mengde) {
        MengdeADT<T> res = this.kopi();
        res.leggTilAlleFra(mengde);
        return res;
    }

    // Returnerer denne mengden minus gitt mengde (alle elementene som er med i denne mengden og ikke er med i den gitte mengden)
    public MengdeADT<T> minus(MengdeADT<T> mengde) {
        MengdeADT<T> res = new TabellMengde<T>();
        for(int i = 0; i < antall; i++) {
            if (!mengde.inneholder(this.tab[i])) {
                res.leggTil(this.tab[i]);
            }
        }
        return res;
    }
    
    // Legg til element i denne mengden
    public void leggTil(T element) {
        if (element != null) {
            if (!this.inneholder(element)) {
                if (this.antall + 1 > this.tab.length) {
                    this.tab = Arrays.copyOf(this.tab, (int)(1.5 * this.tab.length));
                }
                this.tab[antall++] = element;
            }
        }
    }

    // Legg til alle elementer fra en gitt mengde
    public void leggTilAlleFra(MengdeADT<T> mengde) {
        if (mengde.antallElementer() > 0) {
            if (mengde instanceof LenketMengde) {
                LenketMengde<T> lenketMengde = (LenketMengde<T>) mengde;
                Node<T> node = lenketMengde.forste();
                while (node != null) {
                    this.leggTil(node.data);
                    node = node.neste;
                }
            } else {
                T[] mengdeTab = (mengde instanceof TabellMengde ? ((TabellMengde<T>) mengde).tab(): mengde.tilTabell());
                for (int i = 0; i < mengdeTab.length; i++) {
                    this.leggTil(mengdeTab[i]);
                }
            }
        }
    }
    
    // Fjern gitt element fra denne mengden
    public T fjern(T element) {
        for (int i = 0; i < antall; i++) {
            if (this.tab[i].equals(element)) {
                this.antall -= 1;
                this.tab[i] = this.tab[antall];
                this.tab[this.antall] = null;
                return this.tab[i];
            }
        }
        return null;
    }
    
    public void fjernAlleFra(MengdeADT<T> mengde) {
        if (mengde.antallElementer() > 0) {
            if (mengde instanceof LenketMengde) {
                LenketMengde<T> lenketMengde = (LenketMengde<T>) mengde;
                Node<T> node = lenketMengde.forste();
                while (node != null) {
                    this.fjern(node.data);
                    node = node.neste;
                }
            } else {
                T[] mengdeTab = (mengde instanceof TabellMengde ? ((TabellMengde<T>) mengde).tab(): mengde.tilTabell());
                for (int i = 0; i < mengdeTab.length; i++) {
                    this.fjern(mengdeTab[i]);
                }
            }
        }
    }

    // Tabellrepresentasjon av mengden
    public T[] tilTabell() {
        return Arrays.copyOf(this.tab, this.antall);
    }

    // Returnerer antall elementer i mengden
    public int antallElementer() {
        return antall;
    }

    // Returerner en kopi av denne mengden
    private TabellMengde<T> kopi() {
        TabellMengde<T> res = new TabellMengde<T>();
        res.tab = Arrays.copyOf(this.tab, this.antall);
        res.antall = this.antall;
        return res;
    }

    // Tøm denne mengden
    @SuppressWarnings("unchecked")
    private void clear() {
        this.tab = (T[]) new Object[this.initial_cap];
    }
}
