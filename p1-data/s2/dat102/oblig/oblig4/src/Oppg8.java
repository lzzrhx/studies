////////////////////////////////////////////////////////////////////////////////
// OPPGAVE 8
////////////////////////////////////////////////////////////////////////////////

public class Oppg8 {
  
  // Oppgave 8b)
  public static insertion(String[] arr) {
    for (int i = 1; i < arr.length; i++) {
      String val = arr[i];
      int j = i;
      while (j > 0 && val.compareTo(arr[j-1]) < 0) {
        arr[j] = arr[j-1];
        j -= 1;
      }
      arr[j] = val;
    }
  }
  
  // Oppgave 8c)
  /*
    I beste tilfelle er tabellen allerede sortert og den ytre løkken kjøres,
    men den indre løkken kjøres ikke, ettersom verdiene til venstre for en 
    gitt indeks i tabellen aldri vil være større enn verdiene til høyre.
    Dette gir en kjøretid på O(n) uttrykt i O-notasjon.
    (I en tom tabell blir kjøretiden O(1), ettersom både den indre og ytre løkken
    hoppes over, men jeg tror det blir feil svar på oppgaven siden det ikke
    utføres noen sortering i det tilfelle).
  */
  
  // Oppgave 8d)
  /*
    a=delfin:
      v=0, h=8, m=(0+8)//2=4 -> b=eple   -> a < b  -> h=4-1=3
      v=0, h=3, m=(0+3)//2=1 -> b=bok    -> a > b  -> v=1+1=2
      v=2, h=3, m=(2+3)//2=2 -> b=cirka  -> a > c  -> v=2+1=3
      v=3, h=3, m=(3+3)//2=3 -> b=delfin -> a == b -> Streng funnet! Søk avsluttes.
    
    a=kanin:
      v=0, h=8, m=(0+8)//2=4 -> b=eple   -> a > b  -> v=4+1=5
      v=5, h=8, m=(5+8)//2=6 -> b=gaffel -> a > b  -> v=6+1=7
      v=7, h=8, m=(7+8)//2=7 -> b=hane   -> a > b  -> v=7+1=8
      v=8, h=8, m=(8+8)//2=8 -> b=iglo   -> a > b  -> v=8+1=9
      v=9, h=8 -> v > h -> Streng ikke funnet! Søk avsluttes.
    
    Sammenligninger utført:
      delfin: eple, bok, cirka, delfin
      kanin: eple, gaffel, hane, iglo
  */
}
