package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;
import no.hvl.dat100.javel.oppgave2.MonthlyPower;

public class Invoice {
    private static int num = 0;
    private int id;
    private Customer c;          // customer associated with this invoice
    private String month;        // month that the invoice covers
    private double[][] usage;    // power usage this month (per day and per hour)
    private double[][] prices;   // power prices for this month
    private double amount = 0.0; // power price for this month

    public Invoice(Customer c, String month, double[][] usage, double[][] prices) {
        Invoice.num++;
        this.id = Invoice.num;
        this.c = c;
        this.month = month;
        this.usage = usage;
        this.prices = prices;
        computeAmount();
    }

    public void computeAmount() {
        amount = switch (c.agreement()) {
            case SPOTPRICE -> MonthlyPower.computeSpotPrice(usage, prices);
            case POWERSUPPORT -> MonthlyPower.computePowerSupport(usage, prices);
            case NORGESPRICE -> MonthlyPower.computeNorgesPrice(usage);
            default -> 0.0;
        };
    }

    public void printInvoice() {
        System.out.println("Faktura #" + id);
        System.out.println(" Kundenr: " + c.id());
        System.out.println(" Navn:    " + c.name());
        System.out.println(" E-post:  " + c.email());
        System.out.println(" Avtale:  " + switch (c.agreement()) { case SPOTPRICE -> "Spotpris"; case POWERSUPPORT -> "Spotpris /m strømstøtte"; case NORGESPRICE -> "Norgespris"; default -> "Ukjent"; } );
        System.out.println(" - - - - - - - - - - - ");
        System.out.println(" Måned:   " + month);
        System.out.printf( " Forbruk: %.2f kWh%n", MonthlyPower.computePowerUsage(usage));
        System.out.printf( " Amount:  %.2f NOK%n", amount);
    }
}
