////////////////////////////////////////////////////////////////////////////////
// OPPGAVE 9
////////////////////////////////////////////////////////////////////////////////

public class BtNode<T> {
  // Objektvariabler
  private T data;
  private BtNode<T> venstre;
  private BtNode<T> hoyre;
  
  // Konstruktør
  BtNode(T data, BtNode<T> hoyre, BtNode<T> venstre) {
    this.data = data;
    this.venstre = venstre;
    this.hoyre = hoyre;
  }
  
  // Konstruktør
  BtNode(T data) {
    this(data, null, null);
  }
  
  // Gettere/Settere
  public T data()                        { return this.data; }
  public void (T data)                   { this.data = data; }
  public BtNode<T> venstre()             { return this.venstre; }
  public void venstre(BtNode<T> venstre) { this.venstre = venstre; }
  public BtNode<T> hoyre()               { return this.hoyre; }
  public void hoyre(BtNode<T> hoyre)     { this.hoyre = hoyre;}
}

public class BsTre<T extends Comparable<? super T>> {
  // Objektvariabler
  private BtNode<T> rot;
  
  // Konstruktør
  public BsTre(BtNode<T> rot) { this.rot = rot; }
  
  // Oppgave 9a)
  public T finnMinste() {
    /*
      I et binær søketre er dataene allerede sortert.
      Nodene som tilhører venstre barn har lavere (eller lik) verdi sammenlignet ned en gitt node.
      Nodene som tilhærer høyre barn har høyere (eller lik) verdi sammenlignet med en gitt node.
      For å finne minste verdi må vi derfor bevege oss nedover og til venstre i treet, helt til
      vi finner en node som ikke har noen barn til venstre (node.venstre == null).
    */
    BtNode<T> node = this.rot;
    while (node.venstre != null) {
      node = node.venstre;
    }
    return node.element;
  }
  
  // Oppgave 9b)
  private void visPreorden() {
    /*
      I preorden rekkefølge kommer den nåværende noden først, etterfulgt av rekursivt kall på
      venstre barn, og til slutt rekursivt kall på høyre barn,
      ex.:
            1
          /   \
          2    3
        /     / \
        4    5   6
        
        Blir besøkt i rekkefølgen: 1, 2, 4, 3, 5, 6
    */
    if (this.rot != null) { visPreorden(this.rot); }
  }
  
  public void visPreorden(BtNode<T> node) {
    System.out.println(node.data);
    if (node.venstre != null) { visPreorden(node.venstre); }
    if (node.hoyre != null) { visPreorden(node.hoyre); }
  }

  // Oppgave 9c)
  public T finnStorste() {
    if (this.rot != null) { return finnStorste(this.rot); }
  }

  private T finnStorste(BtNode<T> node) {
    T max = node.data;
    if (node.venstre != null) {
      T venstre = finnStorste(node.venstre);
      if (max.compareTo(venstre) < 0) {
        max = venstre;
      }
    }
    if (node.hoyre != null) {
      T hoyre = finnStorste(node.hoyre);
      if (max.compareTo(hoyre) < 0) {
        max = hoyre;
      }
    }
    return max;
  }

  // Oppgave 9d)
  public BsTre<T> tabellTilBsTre(T[] arr) {
    return arr.length == 0 ? null : new BsTre<T>(tabellTilBsTre(arr, 0, arr.length - 1));
  }

  private BtNode<T> tabellTilBsTre(T[] arr, int v, int h) {
    return v > h ? null : new BtNode<T>(arr[(v+h)/2], tabellTilBsTre(arr, v, h-1), tabellTilBsTre(arr, v+1, h));
  }
}