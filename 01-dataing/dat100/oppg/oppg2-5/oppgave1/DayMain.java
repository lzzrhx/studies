package no.hvl.dat100.javel.oppgave1;

public class DayMain {
    public static void main(String[] args) {
        // Data
        double[] usageDay = DayPowerData.usageDay;
        double[] pricesDay = DayPowerData.pricesDay;
        // Variabler
        double spotSum = DailyPower.computeSpotPrice(usageDay, pricesDay);
        double supportSum = DailyPower.computePowerSupport(usageDay, pricesDay);
        // Print resultat
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(" OPPGAVE 1");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        DailyPower.printPower(usageDay, pricesDay);
        System.out.printf("Totalforbruk:                %5.2f kWh%n", DailyPower.computePowerUsage(usageDay));
        System.out.printf("Dagspris med spotpris:       %5.2f NOK%n", spotSum);
        System.out.printf("Dagspris med strømstøtte:    %5.2f NOK (%.2f NOK - %.2f NOK)%n", spotSum-supportSum, spotSum, supportSum);
        System.out.printf("Dagspris med Norgespris:     %5.2f NOK (%.2f NOK/kWh)%n", DailyPower.computeNorgesPrice(usageDay), DailyPower.NORGESPRIS_KWH);
        System.out.printf("Største forbruk per time:    %5.2f kWh%n", DailyPower.findPeakUsage(usageDay));
        System.out.printf("Gj.snitt forbruk per time:   %5.2f kWh%n", DailyPower.findAvgPower(usageDay));
        System.out.println();
    }
}
