///////////////////////////////////////////////////////////////////////////////
// OPPGAVE 5
///////////////////////////////////////////////////////////////////////////////

// Del c - e)
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
public class SnarestMulig extends Bestilling {
  
  // Objektvariabler
  private int maxtid;
  
  // Konstruktør
  public SnarestMulig(int kontaktnummer, String kundenavn, String adresse, int maxtid) {
    super(kontaktnummer, kundenavn, adresse);
    this.maxtid = maxtid;
  }
  
  // Strengrepresentasjon av objektet
  public String toString() {
    return super.toString() + ", maxtid: " + maxtid;
  }
  
  // Skriv ut strengrepresentasjon av objektet
  public void skrivUt() {
    System.out.println(this);
  }
  
}
