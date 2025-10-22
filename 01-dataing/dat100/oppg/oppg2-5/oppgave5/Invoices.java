package no.hvl.dat100.javel.oppgave5;

public class Invoices {
    public static void processInvoices(Invoice[] invoices) {
        for (Invoice invoice : invoices) {
            invoice.printInvoice();
            System.out.println("\n-------------------------------------------------------------------------------\n");
        }
    }
}
