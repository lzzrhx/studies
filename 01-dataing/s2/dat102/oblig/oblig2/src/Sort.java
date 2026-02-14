package src;

public class Sort {
    private static int tmp;
   
    ////////////////////////////////////////////////////////////////////////////////
    // Simple
    ////////////////////////////////////////////////////////////////////////////////

    // Bubble - Best: n / Avg: n^2 / Worst: n^2 / Mem: 1 / Stable: Yes / In-Place: Yes / Method: Exchanging / Parallel: ?
    public static void bubble(int[] arr) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i-1]) {
                    tmp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = tmp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Selection - Best: n^2 / Avg: n^2 / Worst: n^2 / Mem: 1 / Stable: No / In-place: Yes / Method: Selection / Parallel: ?
    public static void selection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }

    // Insertion - Best: n / Avg: n^2 / Worst: n^2 / Mem: 1 / Stable: Yes / In-place: Yes / Method: Insertion / Parallel: ?
    public static void insertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j-1] > arr[j]) {
                tmp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = tmp;
                j -= 1;
            }
        }
    }


    ////////////////////////////////////////////////////////////////////////////////
    // Efficient
    ////////////////////////////////////////////////////////////////////////////////
    // Heap - Best: n log n / Avg: n log n / Worst: n log n / Mem: 1 / Stable: No / In-place: Yes / Method: Selection / Parallel: ?
    public static void heap (int[] tab) {
    }

    // Merge - Best: n log n / Avg: n log n / Worst: n log n / Mem: n / Stable: Yes / In-place: No / Method: Merging / Parallel: Yes
    //public void ...(int[] tab) {}
    // Quick - Best: n log n / Avg: n log n / Worst: n^2 / Mem: log n / Stable: No / In-place: Yes / Method: Partitioning / Parallel: ?
    //public void ...(int[] tab) {}


    ////////////////////////////////////////////////////////////////////////////////
    // Hybrid
    ////////////////////////////////////////////////////////////////////////////////
    // Tim - Best: n / Avg: n log n / Worst: n log n / Mem: n / Stable: Yes / In-place: No / Method: Insertion & Merging / Parallel: ?
    //public void ...(int[] tab) {}
    // Intro - Best: n log n / Avg: n log n / Worst: n log n / Mem: log n / Stable: No / In-place: Yes / Method: Partitioning & Selection (Quicksort & heapsort) / Parallel: ?
    //public void ...(int[] tab) {}


    ////////////////////////////////////////////////////////////////////////////////
    // Distribution
    ////////////////////////////////////////////////////////////////////////////////
    // (Integer) Counting - Best: - / Avg: n+r / Worst: n+r / Mem: n+r / Stable: Yes / In-place: Yes / Parallel: ?
    //public void ...(int[] tab) {}
    // MSD Radix - Best: n / Avg: n*k/d / Worst: n*k/d / Mem: n+2^d / Stable: Yes / In-place: No / Parallel: ?
    //public void ...(int[] tab) {}

}
