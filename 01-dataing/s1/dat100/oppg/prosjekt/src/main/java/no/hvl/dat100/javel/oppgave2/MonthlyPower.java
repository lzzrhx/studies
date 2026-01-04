package no.hvl.dat100.javel.oppgave2;
import no.hvl.dat100.javel.oppgave1.DailyPower;

public class MonthlyPower {

    public static final double THRESHOLD_HYTTE = 1000.0;
    public static final double THRESHOLD_BOLIG = 5000.0;

    // a) print power usage for a month
    public static void printPowerUsage(double[][] usage) {
        for (int i = 0; i < usage.length; i++) {
            System.out.print("Dag " + (i+1) + ":\n");
            for (int j = 0; j < usage[i].length; j++) {
                System.out.printf(((j > 0 && j % 6 == 0) ? "\n" : "") + "  %.2f kWh", usage[i][j]);
            }
            System.out.println();
        }
    }

    // b) print power prices for a month
    public static void printPowerPrices(double[][] prices) {
        for (int i = 0; i < prices.length; i++) {
            System.out.print("Dag " + (i+1) + ":\n");
            for (int j = 0; j < prices[i].length; j++) {
                System.out.printf(((j > 0 && j % 6 == 0) ? "\n" : "") + "  %.2f NOK", prices[i][j]);
            }
            System.out.println();
        }
    }
    
    // a + b)
    public static void printPower(double[][] usage, double[][] prices) {
        for (int i = 0; i < usage.length; i++) {
            System.out.printf((i > 0 ? "%n" : "" ) + "Dag %d/%d (%.2f kWh)%n", i+1, usage.length, DailyPower.computePowerUsage(usage[i]) );
            System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
            System.out.println("  Tid:           |  kWh:  | NOK/kWh:  |  Tid:           |  kWh:  | NOK/kWh:    ");
            System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
            for (int j = 0; j < prices[i].length; j++) {
                int k = (j > 0 && j % 2 == 1) ? j / 2 + usage[i].length / 2  : j / 2;
                System.out.printf(((j > 0 && j % 2 == 0) ? "%n" : (j > 0 ? "  |" : "")) + "  %02d:00 - %02d:59  |  %.2f  |  %.2f   ", k, k, usage[i][k], prices[i][k]);
            }
            System.out.println();
            System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        }
        System.out.println();
    }

    // c) compute total power usage for a month
    public static double computePowerUsage(double[][] usage) {
        double sum = 0;
        for (int i = 0; i < usage.length; i++) {
            for (int j = 0; j < usage[i].length; j++) {
                sum += usage[i][j];
            }
        }
        return sum;
    }

    // d) determine whether a given threshold in powerusage for the month has been exceeded
    public static boolean exceedThreshold(double[][] usage) {
        return exceedThreshold(usage, THRESHOLD_BOLIG);
    }
    public static boolean exceedThreshold(double[][] usage, double threshold) {
        double sum = 0;
        for (int i = 0; i < usage.length; i++) {
            for (int j = 0; j < usage[i].length; j++) {
                sum += usage[i][j];
                if (sum > threshold) {
                    return true;
                }
            }
        }
        return false;
    }

    // e) compute spot price
    public static double computeSpotPrice(double[][] usage, double[][] prices) {
        double price = 0.0;
        for (int i = 0; i < usage.length; i++) {
            for (int j = 0; j < usage[i].length; j++) {
                price += usage[i][j] * prices[i][j];
            }
        }
        return price;
    }

    // f) power support for the month
    public static double computePowerSupport(double[][] usage, double[][] prices) {
        double support = 0;
        for (int i = 0; i < usage.length; i++) {
            support += DailyPower.computePowerSupport(usage[i], prices[i]);
        }
        return support;
    }

    // g) Norgesprice for the month
    public static double computeNorgesPrice(double[][] usage) {
        double price = 0;
        for (double[] day : usage) {
            price += DailyPower.computeNorgesPrice(day);
        }
        return price;
    }
}
