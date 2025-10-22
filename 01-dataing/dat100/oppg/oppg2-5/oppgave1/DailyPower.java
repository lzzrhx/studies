package no.hvl.dat100.javel.oppgave1;

public class DailyPower {
    private static final double THRESHOLD = 0.9375;
    private static final double PERCENTAGE = 0.9;
    public static final double NORGESPRIS_KWH = 0.5;

    // a) print power prices during a day
    public static void printPowerPrices(double[] prices) {
        for (int i = 0; i < prices.length; i++) {
            System.out.printf("%02d:00 - %02d:59 | %.2f NOK%n", i, i, prices[i]);
        }
    }

    // b) print power usage during a day
    public static void printPowerUsage(double[] usage) {
        for (int i = 0; i < usage.length; i++) {
            System.out.printf("%02d:00 - %02d:59 | %.2f kWh%n", i, i, usage[i]);
        }
    }
    
    // a + b)
    public static void printPower(double[] usage, double[] prices) {
        System.out.println("Tid:             | kWh:  | NOK/kWh:  | Pris (NOK):");
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        for (int i = 0; i < prices.length; i++) {
            System.out.printf("  %02d:00 - %02d:59  | %.2f  | %.2f      | %.2f%n", i, i, usage[i], prices[i], usage[i] * prices[i]);
        }
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
    }

    // c) compute power usage for a single day
    public static double computePowerUsage(double[] usage) {
        double sum = 0;
        for (int i = 0; i < usage.length; i++) {
            sum += usage[i];
        }
        return sum;
    }

    // d) compute spot price for a single day
    public static double computeSpotPrice(double[] usage, double[] prices) {
        double price = 0;
        for (int i = 0; i < usage.length; i++) {
            price += usage[i] * prices[i];
        }
        return price;
    }

    // e) compute power support for a given usage and price
    private static double getSupport(double usage, double price) {
        return (usage * price > THRESHOLD) ? (usage * price - THRESHOLD) * PERCENTAGE : 0.0;
    }

    // f) compute power support for a single day
    public static double computePowerSupport(double[] usage, double[] prices) {
        double support = 0;
        for (int i = 0; i < usage.length; i++) {
            support += getSupport(usage[i], prices[i]);
        }
        return support;
    }

    // g) compute norges pris for a single day
    public static double computeNorgesPrice(double[] usage) {
        double price = 0;
        for (int i = 0; i < usage.length; i++) {
            price += usage[i] * NORGESPRIS_KWH;
        }
        return price;
    }

    // h) compute peak usage during a single day
    public static double findPeakUsage(double[] usage) {
        double peak = 0.0;
        for (int i = 0; i < usage.length; i++) {
            if (usage[i] > peak) {
                peak = usage[i];
            }
        }
        return peak;
    }

    // i)
    public static double findAvgPower(double[] usage) {
        return computePowerUsage(usage) / (double)usage.length;
    }
}
