package src;

public class InsertSort {
    public static <T extends Comparable<? super T>> void run(T[] tab) {
        for (int i = 1; i <= tab.length - 1; i++) {
            T val = tab[i];
            int j = i - 1;
            while (j >= 0 && val.compareTo(tab[j]) < 0) {
                tab[j + 1] = tab[j--];
            }
            tab[j + 1] = val;
        }
    }
    
    public static <T extends Comparable<? super T>> void run2(T[] tab) {
        T min = tab[0];
        int min_i = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].compareTo(min) < 0) {
                min_i = i;
                min = tab[i];
            }
        }
        tab[min_i] = tab[0];
        tab[0] = min;
        int first = 1;
        int last = tab.length - 1;
        for (int i = first + 1; i <= last; i++) {
            T val = tab[i];
            int j = i - 1;
            while (j >= first && val.compareTo(tab[j]) < 0) {
                tab[j + 1] = tab[j--];
            }
            tab[j + 1] = val;
        }
    }
}
