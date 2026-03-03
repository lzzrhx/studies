package src;

public interface MengdeADT<T> {
    boolean erTom();
    boolean inneholder(T element);
    boolean erDelmengdeAv(MengdeADT<T> mengde);
    boolean erLik(MengdeADT<T> mengde);
    boolean erDisjunkt(MengdeADT<T> mengde);
    MengdeADT<T> snitt(MengdeADT<T> mengde);
    MengdeADT<T> union(MengdeADT<T> mengde);
    MengdeADT<T> minus(MengdeADT<T> mengde);
    void leggTil(T element);
    void leggTilAlleFra(MengdeADT<T> mengde);
    T fjern(T element);
    T[] tilTabell();
    int antallElementer();
}
