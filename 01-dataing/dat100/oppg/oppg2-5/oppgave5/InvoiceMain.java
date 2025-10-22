package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;
import no.hvl.dat100.javel.oppgave2.MonthPowerData;

public class InvoiceMain {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(" OPPGAVE 5");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        Customer c1 = new Customer("Navn Navnenavn", "epost@eksempel.com", PowerAgreementType.SPOTPRICE);
        Customer c2 = new Customer("Ekse Mpel", "epost@eksempel.com", PowerAgreementType.POWERSUPPORT);
        Customer c3 = new Customer("Lorem Ipsum", "epost@eksempel.com", PowerAgreementType.NORGESPRICE);
        Invoice[] invoices = new Invoice[3];
        invoices[0] = new Invoice(c1, "Januar", CustomerPowerUsageData.usage_month_customer1, MonthPowerData.pricesMonth);
        invoices[1] = new Invoice(c3, "Januar", CustomerPowerUsageData.usage_month_customer2, MonthPowerData.pricesMonth);
        invoices[2] = new Invoice(c2, "Januar", CustomerPowerUsageData.usage_month_customer3, MonthPowerData.pricesMonth);
        Invoices.processInvoices(invoices);
    }
}
