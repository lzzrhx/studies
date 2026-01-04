public class OppgaveG2 {
    public static void main(String[] args) {
        Konto konto1 = new Konto();
        Konto konto2 = new Konto();
        Konto konto3 = new Konto();
        konto1.innskudd(1000.0);
        konto2.innskudd(10000.0);
        konto3.innskudd(53.5);
        konto2.uttak(4500.0);
        System.out.println("Totalsaldo: " + Konto.saldoAll());
    }
}
