package src;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Iterator;

public class JavaSetToMengde<T> implements MengdeADT<T> {
    private Set<T> set = new LinkedHashSet<T>();
    
    public boolean erTom() {
        return set.isEmpty();
    }

    public boolean inneholder(T element) {
        return set.contains(element);
    }

    public boolean erDelmengdeAv(MengdeADT<T> mengde) {
        if (this.antallElementer() > mengde.antallElementer()) {
            return false;
        } else {
            Iterator<T> iterator = set.iterator();
            while (iterator.hasNext()) {
                if (!mengde.inneholder(iterator.next())) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean erLik(MengdeADT<T> mengde) {
        if (this.antallElementer() != mengde.antallElementer()) {
            return false;
        }
        return this.erDelmengdeAv(mengde);
    }

    public boolean erDisjunkt(MengdeADT<T> mengde) {
        Iterator<T> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (mengde.inneholder(iterator.next())) {
                return false;
            }
        }
        return true;
    }

    public MengdeADT<T> snitt(MengdeADT<T> mengde) {
        MengdeADT<T> res = this.kopi();
        if (mengde instanceof JavaSetToMengde) {
            ((JavaSetToMengde<T>)res).set.retainAll(((JavaSetToMengde<T>)mengde).set);
        } else {
            Iterator<T> iterator = set.iterator();
            while (iterator.hasNext()) {
                T item = iterator.next();
                if (mengde.inneholder(item)) {
                    res.leggTil(item);
                }
            } 
        }
        return res;
    }

    public MengdeADT<T> union(MengdeADT<T> mengde) {
        MengdeADT<T> res = this.kopi();
        res.leggTilAlleFra(mengde);
        return res;
    }

    public MengdeADT<T> minus(MengdeADT<T> mengde) {
        MengdeADT<T> res = this.kopi();
        res.fjernAlleFra(mengde);
        return res;
    }

    public void leggTil(T element) {
        this.set.add(element);
    }

    public void leggTilAlleFra(MengdeADT<T> mengde) {
        if (mengde.antallElementer() > 0) {
            if (mengde instanceof JavaSetToMengde) {
                this.set.addAll(((JavaSetToMengde<T>)mengde).set);
            } else {
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
    }

    public T fjern(T element) {
        this.set.remove(element);
        return element;
    }

    public void fjernAlleFra(MengdeADT<T> mengde) {
        if (mengde.antallElementer() > 0) {
            if (mengde instanceof JavaSetToMengde) {
                this.set.removeAll(((JavaSetToMengde<T>)mengde).set);
            } else {
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
    }

    @SuppressWarnings("unchecked")
    public T[] tilTabell() {
        return (T[])this.set.toArray();
    }

    public int antallElementer() {
        return this.set.size();
    }

    private JavaSetToMengde<T> kopi() {
        JavaSetToMengde<T> res = new JavaSetToMengde<T>();
        ((JavaSetToMengde<T>)res).set.addAll(this.set);
        return res;
    }
}
