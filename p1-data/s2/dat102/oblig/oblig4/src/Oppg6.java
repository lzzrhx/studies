////////////////////////////////////////////////////////////////////////////////
// OPPGAVE 6
////////////////////////////////////////////////////////////////////////////////

public class Oppg6 {
  public static void main(String[] args) {
    oppg6a();
  }
  
  // Oppgave 6a)
  public static void oppg6a() {
    Node forste = new Node(1);
    forste.neste = new Node(2);
    forste.neste.neste = new Node(3);
  }
  
  // Oppgave 6b)
  public static void settInnBakerst(Node forste, int verdi) {
    Node node = forste;
    while (node.neste != null) {
      node = node.neste;
    }
    node.neste = new Node(verdi);
  }
}