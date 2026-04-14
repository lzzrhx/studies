////////////////////////////////////////////////////////////////////////////////
// OPPGAVE 7
////////////////////////////////////////////////////////////////////////////////

// Oppgave 7a)
public class Oppg7 {
  public static int antallMaater(int trinn) {
    return (trinn <= 2) ? trinn : antallMaater(trinn-1) + antallMaater(trinn-2);
  }
}

// Oppgave 7b)
public class Oppg7Test {
  @Test
  public static void test() {
    assertEquals(1, Oppg7.antallMaater(1));
    assertEquals(2, Oppg7.antallMaater(2));
    assertEquals(3, Oppg7.antallMaater(3));
    assertEquals(5, Oppg7.antallMaater(4));
    assertEquals(8, Oppg7.antallMaater(5));
  }
}