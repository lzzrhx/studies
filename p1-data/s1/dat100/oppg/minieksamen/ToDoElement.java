///////////////////////////////////////////////////////////////////////////////
// OPPGAVE 4
///////////////////////////////////////////////////////////////////////////////

// Del a)
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
public class ToDoElement {
  
  // Klassevariabler
  private static int num = 0;
  
  // Objektvariabler
  private int id;
  private String beskrivelse;
  private int nummer;
  private int prioritet;
  
  // Konstruktør
  public ToDoElement(String beskrivelse, int nummer, int prioritet) {
    ToDoElement.num++;
    this.id=ToDoElement.num;
    this.beskrivelse = beskrivelse;
    this.nummer = nummer;
    this.prioritet = prioritet;
  }
  
  // Getter for beskrivelse
  public String beskrivelse() {
    return  beskrivelse;
  }
  
  // Setter for beskrivelse
  public void beskrivelse(String beskrivelse) {
    this.beskrivelse = beskrivelse;
  }
  
  // Getter for id
  public int id() {
    return id;
  }
  
  // Getter for nummer
  public int nummer() {
    return nummer;
  }
  
  // Setter for nummer
  public void nummer(int nummer) {
    this.nummer = nummer;
  }
  
  // Getter for prioritet
  public int prioritet() {
    return prioritet;
  }
  
  // Setter for prioritet
  public void prioritet(int prioritet) {
    this.prioritet = prioritet;
  }
  
  // Strengrepresentasjon av objektet
  public String toString() {
    return beskrivelse + "\n" + "Nummer   : " + nummer + "\n" + "Prioritet: " + prioritet;
  }

}
