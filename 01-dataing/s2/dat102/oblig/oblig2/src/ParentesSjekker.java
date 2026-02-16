package src;

// Sjekker om åpnende og lukkende parenteser i streng er formatert riktig
public class ParentesSjekker {
    
    public static boolean sjekk(String s) {
        return sjekk(s, false);
    }

    public static boolean sjekk(String s, boolean debug) {
        if (debug) {
            System.out.println();
            System.out.println(" KJØRER PARENTES SJEKK");
            System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.printf("Streng:%n%s%n%n", s);
        }
        StackADT<Character> par0 = new Stack<>(false);
        // Fyll stabel "par0" med alle parenteser fra strengen
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}') {
                par0.push(c);
            }
        }
        // Lag ny stabel for åpne parenteser
        StackADT<Character> par1  = new Stack<>(debug);
        while (!par0.isEmpty()) {
            Character c0 = par0.pop();
            Character c1 = par1.peek();
            // Sammenlign parentes på toppen av begge stablene
            if ((c1 != null) && ((c0 == '(' && c1 == ')') || (c0 == '[' && c1 == ']') || (c0 == '{' && c1 == '}'))) {
                // Fjern parentes fra toppen av "åpne parenteser" stabelen hvis match er funnet
                par1.pop();
            }
            else {
                // Push parentesen fra "par0" til "par1" vis parentesene ikke matcher
                par1.push(c0);
                // Hvis en åpnende parentes er funnet som ikke har lukkende match kan det konkluderes at parentesene i strengen er feilformatert og søket kan avsluttes tidlig
                if (c0 == '(' || c0 == '[' || c0 == '{') {
                    break;
                }
            }
        }
        // Sjekk om det ble funnet match til alle åpne parenteser (par1 stabelen skal i så fall være tom)
        boolean res = par1.isEmpty();
        if (debug) {
            System.out.println("\nParentes sjekk utført: Parenteser er " + (res ? "" : "IKKE ") + "riktig formatert.\n");
        }
        return res;
    }
}
