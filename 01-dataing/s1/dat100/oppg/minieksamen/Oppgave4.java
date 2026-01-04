///////////////////////////////////////////////////////////////////////////////
// OPPGAVE 4
///////////////////////////////////////////////////////////////////////////////

// Del c)
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
public class Oppgave4 {
  
  // Entry-point for programmet
  public static void main(String[] args) {
    ToDoListe todoListe = new ToDoListe(10);
    todoListe.leggTil(new ToDoElement("Gjennomfør oppgave 4.", 1, 1));
    todoListe.leggTil(new ToDoElement("Gjennomfør oppgave 5.", 2, 2));
    System.out.println(todoListe.finnViktig());
  }

}
