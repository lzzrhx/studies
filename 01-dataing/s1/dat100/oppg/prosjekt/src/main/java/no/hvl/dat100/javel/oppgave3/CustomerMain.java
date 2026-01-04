package no.hvl.dat100.javel.oppgave3;

public class CustomerMain {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(" OPPGAVE 3");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        Customer c1 = new Customer("Navn Navnenavn", "e@mail.com", PowerAgreementType.SPOTPRICE, true);
        Customer c2 = new Customer("Eksempel Navn", "eksempel@epost.com", PowerAgreementType.POWERSUPPORT, true);
        Customer c3 = new Customer("Fornavn Etternavn", "fornavn@gmail.com", PowerAgreementType.NORGESPRICE, true);
    }
}
