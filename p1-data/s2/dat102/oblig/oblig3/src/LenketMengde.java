package src;

import java.util.Arrays;

public class LenketMengde<T> implements MengdeADT<T> {
    // Objektvariabler
    private int antall = 0;
    private Node<T> forste = null;

    // Getter for forste
    //public Node<T> forste() {
    //    return forste;
    //}

    // Sjekk om mengden er tom
    public boolean erTom() {
        return forste == null;
    }

    // Sjekk om mengden inneholder et gitt element
    public boolean inneholder(T element) {
        Node<T> node = forste;
        while (node != null) {
            if (element.equals(node.data)) { return true; }
            node = node.neste;
        }
        return false;
    }
    
    // Sjekk om denne mengden er en delmengde av en gitt delmengde
    public boolean erDelmengdeAv(MengdeADT<T> mengde) {
        if (this.antallElementer() > mengde.antallElementer()) {
            return false;
        } else {
            Node<T> node = forste;
            while (node != null) {
                if (!mengde.inneholder(node.data)) { return false; }
                node = node.neste;
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
        Node<T> node = forste;
        while (node != null) {
            if (mengde.inneholder(node.data)) { return false; }
            node = node.neste;
        }
        return true;
    }

    // Returnerer snitt av denne mengden og en gitt mengde (felles elementer)
    public MengdeADT<T> snitt(MengdeADT<T> mengde) {
        MengdeADT<T> res = new LenketMengde<T>();
        Node<T> node = forste;
        while (node != null) {
            if (mengde.inneholder(node.data)) { res.leggTil(node.data); }
            node = node.neste;
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
        MengdeADT<T> res = this.kopi();
        if (mengde.antallElementer() > 0) {
            /*if (mengde instanceof LenketMengde) {
                LenketMengde<T> lenketMengde = (LenketMengde<T>) mengde;
                Node<T> node = lenketMengde.forste;
                while (node != null) {
                    res.fjern(node.data);
                    node = node.neste;
                }
            }
            else {
            */
                T[] mengdeTab = (mengde instanceof TabellMengde ? ((TabellMengde<T>) mengde).tab(): mengde.tilTabell());
                for (int i = 0; i < mengdeTab.length; i++) {
                    res.fjern(mengdeTab[i]);
                }
            //}
        }
        return res;
    }
    
    // Legg til element i denne mengden
    public void leggTil(T element) {
        if (element != null) {
            if (this.erTom()) {
                forste = new Node<T>(element);
                this.antall += 1;
            }
            else if (!this.inneholder(element)) {
                Node<T> node = forste;
                while (node.neste != null) { node = node.neste; }
                node.neste = new Node<T>(element);
                this.antall += 1;
            }
        }
    }

    // Legg til alle elementer fra en gitt mengde
    public void leggTilAlleFra(MengdeADT<T> mengde) {
        if (mengde.antallElementer() > 0) {
            if (mengde instanceof LenketMengde) {
                LenketMengde<T> lenketMengde = (LenketMengde<T>) mengde;
                Node<T> node = lenketMengde.forste;
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
        T res = null;
        Node<T> node = forste;
        Node<T> forrige = null;
        while (node != null) {
            if (node.data.equals(element)) {
                this.antall -= 1;
                res = node.data;
                if (forrige == null) {
                    forste = node.neste != null ? node.neste : null;
                } else {
                    forrige.neste = node.neste != null ? node.neste : null;
                }
            }
            forrige = node;
            node = node.neste;
        }
        return res;
    }

    // Tabellrepresentasjon av mengden
    @SuppressWarnings("unchecked")
    public T[] tilTabell() {
        T[] res = (T[]) new Object[this.antall];
        if (!this.erTom()) {
            Node<T> node = forste;
            int i = 0;
            while (node != null) {
                res[i] = node.data;
                node = node.neste;
                i += 1;
            }
        }
        return res;
    }

    // Returnerer antall elementer i mengden
    public int antallElementer() {
        return antall;
    }

    // Returerner en kopi av denne mengden
    private LenketMengde<T> kopi() {
        LenketMengde<T> res = new LenketMengde<T>();
        if (this.antallElementer() > 0) {
            res.antall = this.antall;
            res.forste = new Node<T>(this.forste.data);
            Node<T> node = this.forste.neste;
            Node<T> resNode = res.forste;
            while (node != null) {
                resNode.neste = new Node<T>(node.data);
                node = node.neste;
                resNode = resNode.neste;
            }
        }
        return res;
    }

    // Tøm denne mengden
    private void clear() {
        Node<T> node = this.forste;
        Node<T> forrige = null;
        while (node != null) {
            forrige = node;
            node = node.neste;
            forrige.neste = null;
        }
        this.forste = null;
        this.antall = 0;
    }
}
