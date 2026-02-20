///////////////////////////////////////////////////////////////////////////////
// OPPGAVE 4
///////////////////////////////////////////////////////////////////////////////

// Del b)
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
public class ToDoListe {
  
  // Klassevariabler
  private static int num = 0;
  
  // Objektvariabler
  private int id = 0;
  private ToDoElement[] todoTab;
  private int antall = 0;
  
  // Konstruktør
  public ToDoListe(int maksAntall) {
    ToDoListe.num++;
    this.id=ToDoListe.num;
    todoTab = new ToDoElement[maksAntall];
  }
  
  // Legg til element
  public void leggTil(ToDoElement tde) {
    if (antall < todoTab.length) {
      todoTab[antall] = tde;
      antall++;
    } else {
      System.out.println("ERR! Ikke ledig plass for å legge til nytt element (" + tde.id() + ") i tabellen " + this.id + ".");
    }
  }
  
  // Finn elmentet i listen med høyest prioritet
  public ToDoElement finnViktig() {
    ToDoElement tde = null;
    if (antall > 0) {
      tde = todoTab[0];
      for (int i = 1; i < antall; i++) {
        if (todoTab[i].prioritet() < tde.prioritet()) {
          tde=todoTab[i];
        }
      }
    }
    return tde;
  }

}
