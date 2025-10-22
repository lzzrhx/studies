package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

public class CustomersMain {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(" OPPGAVE 4");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        Customers customers = new Customers(10);
        System.out.println("customers.countNonNull(): " + customers.countNonNull());
        System.out.println("customers.getCustomer(2): " + customers.getCustomer(2));
        System.out.println("customers.addCustomer(new Customer(\"navn1\", \"epost1\", PowerAgreementType.SPOTPRICE)): " + customers.addCustomer(new Customer("navn1", "epost1", PowerAgreementType.SPOTPRICE)));
        System.out.println("customers.countNonNull(): " + customers.countNonNull());
        System.out.println("customers.getCustomer(2): " + customers.getCustomer(2));
        System.out.println("customers.addCustomer(new Customer(\"navn2\", \"epost2\", PowerAgreementType.POWERSUPPORT)): " + customers.addCustomer(new Customer("navn2", "epost2", PowerAgreementType.POWERSUPPORT)));
        System.out.println("customers.addCustomer(new Customer(\"navn3\", \"epost3\", PowerAgreementType.NORGESPRICE)): " + customers.addCustomer(new Customer("navn3", "epost3", PowerAgreementType.NORGESPRICE)));
        System.out.println("customers.addCustomer(new Customer(\"navn4\", \"epost4\", PowerAgreementType.SPOTPRICE)): " + customers.addCustomer(new Customer("navn4", "epost4", PowerAgreementType.SPOTPRICE)));
        System.out.println("customers.addCustomer(new Customer(\"navn5\", \"epost5\", PowerAgreementType.POWERSUPPORT)): " + customers.addCustomer(new Customer("navn5", "epost5", PowerAgreementType.POWERSUPPORT)));
        System.out.println("customers.addCustomer(new Customer(\"navn6\", \"epost6\", PowerAgreementType.NORGESPRICE)): " + customers.addCustomer(new Customer("navn6", "epost6", PowerAgreementType.NORGESPRICE)));
        System.out.println("customers.addCustomer(new Customer(\"navn7\", \"epost7\", PowerAgreementType.SPOTPRICE)): " + customers.addCustomer(new Customer("navn7", "epost7", PowerAgreementType.SPOTPRICE)));
        System.out.println("customers.countNonNull(): " + customers.countNonNull());
        System.out.println("customers.getCustomer(2): " + customers.getCustomer(2));
        System.out.println("customers.removeCustomer(2): " + customers.removeCustomer(2));
        System.out.println("customers.countNonNull(): " + customers.countNonNull());
        System.out.println("customers.getCustomer(2): " + customers.getCustomer(2));
        System.out.println("customers.getCustomers(): ");
        Customer[] customersNonEmpty = customers.getCustomers();
        for (int i = 0; i < customersNonEmpty.length; i++) {
            System.out.println(customersNonEmpty[i]);
        }
    }
}
