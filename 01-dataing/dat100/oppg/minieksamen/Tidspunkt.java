///////////////////////////////////////////////////////////////////////////////
// OPPGAVE 5
///////////////////////////////////////////////////////////////////////////////

// Del c - e)
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
public class Tidspunkt extends Bestilling {
  
  // Objektvariabler
  private String dato;
  private String tidspunkt;

  // Konstruktør
  public Tidspunkt(int kontaktnummer, String kundenavn, String adresse, String dato, String tidspunkt) {
    super(kontaktnummer, kundenavn, adresse);
    this.dato = dato;
    this.tidspunkt = tidspunkt;
  }
  
  // Strengrepresentasjon av objektet
  public String toString() {
    return super.toString() + ", dato: " + dato + ", tidspunkt: " + tidspunkt;
  }
  
  // Skriv ut strengrepresentasjon av objektet
  public void skrivUt() {
    System.out.println(this);
  }

}
