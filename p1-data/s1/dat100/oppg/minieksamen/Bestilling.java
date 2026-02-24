///////////////////////////////////////////////////////////////////////////////
// OPPGAVE 5
///////////////////////////////////////////////////////////////////////////////

// Del a & b)
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
public class Bestilling {
  
  // Klassevariabler
  private static int num = 0;
  
  // Objektvariabler
  private int id;
  private int kontaktnummer;
  private String kundenavn;
  private String adresse;

  // Konstruktør
  public Bestilling(int kontaktnummer, String kundenavn, String adresse) {
    Bestilling.num++;
    this.id = Bestilling.num;
    this.kontaktnummer = kontaktnummer;
    this.kundenavn = kundenavn;
    this.adresse = adresse;
  }
  
  // Getter for kontaktnummer
  public int kontaktnummer() {
    return kontaktnummer;
  }
  
  // Setter for kontaktnummer
  public void kontaktnummer(int kontaktnummer) {
    this.kontaktnummer = kontaktnummer;
  }
  
  // Getter for kundenavn
  public String kundenavn() {
    return kundenavn;
  }
  
  // Setter for kundenavn
  public void kundenavn(String kundenavn) {
    this.kundenavn = kundenavn;
  }
  
  // Getter for adresse
  public String adresse() {
    return adresse;
  }
  
  // Setter for adresse
  public void adresse(String adresse) {
    this.adresse = adresse;
  }
  
  // Strengrepresentasjon av objektet
  public String toString() {
    return "Bestilling (" + id + ") - kontaktnummer: " + kontaktnummer + ", kundenavn: " + kundenavn + ", adresse: " + adresse;
  }
  
  // Skriv ut strengrepresentasjon av objektet
  public void skrivUt() {
    System.out.println(this);
  }
}
