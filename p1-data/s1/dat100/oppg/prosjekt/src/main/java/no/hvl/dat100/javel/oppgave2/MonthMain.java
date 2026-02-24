package no.hvl.dat100.javel.oppgave2;
import no.hvl.dat100.javel.oppgave1.DailyPower;

public class MonthMain {
    public static void main(String[] args) {
        // Data
        double[][] pricesMonth = MonthPowerData.pricesMonth;
        double[][] usageMonth = MonthPowerData.usageMonth;
        // Variabler
        double spotSum = MonthlyPower.computeSpotPrice(usageMonth, pricesMonth);
        double supportSum = MonthlyPower.computePowerSupport(usageMonth, pricesMonth);
        // Print resultat
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(" OPPGAVE 2");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        MonthlyPower.printPower(usageMonth, pricesMonth);
        System.out.printf("Totalforbruk:                  %5.2f kWh%n", MonthlyPower.computePowerUsage(usageMonth));
        System.out.printf("Over grense (primær / hytte):  %s / %s%n", MonthlyPower.exceedThreshold(usageMonth) ? "Ja" : "Nei", MonthlyPower.exceedThreshold(usageMonth, MonthlyPower.THRESHOLD_HYTTE) ? "Ja" : "Nei");
        System.out.printf("Månedspris med spotpris:       %5.2f NOK%n", spotSum);
        System.out.printf("Månedspris med strømstøtte:    %5.2f NOK (%.2f NOK - %.2f NOK)%n", spotSum-supportSum, spotSum, supportSum);
        System.out.printf("Månedspris med Norgespris:     %5.2f NOK (%.2f NOK/kWh)%n", MonthlyPower.computeNorgesPrice(usageMonth), DailyPower.NORGESPRIS_KWH);
        System.out.println();
    }
}
