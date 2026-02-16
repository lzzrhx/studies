package src;

public class Sort {
    public static <T extends Comparable<? super T>> void insertion(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T tmp = arr[i];
            int j = i;
            while (j > 0 && tmp.compareTo(arr[j-1]) < 0) {
                arr[j] = arr[j---1];
            }
            arr[j] = tmp;
        }
    }
    
    public static <T extends Comparable<? super T>> void insertionMod(T[] arr) {
        T tmp;
        for (int i = arr.length - 1; i > 0 ; i--) {
            if (arr[i].compareTo(arr[i-1]) < 0) {
                tmp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = tmp;
            }
        }
        for (int i = 1; i < arr.length; i += 1) {
            T min = arr[i];
            int j = i - 1;
            if (i + 1 < arr.length - 1) {
                T max = arr[i+1];
                if (max.compareTo(min) < 0) {
                    max = arr[i];
                    min = arr[i+1];
                }
                while (j > 1 && max.compareTo(arr[j]) < 0) {
                    arr[j+2] = arr[j];
                    j -= 1;
                }
                arr[j+2] = max;
                i += 1;
            }
            while (j > 0 && min.compareTo(arr[j]) < 0) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j+1] = min;
        }
    }
}
