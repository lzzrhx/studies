package src;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

// https://en.wikipedia.org/wiki/Sorting_algorithm
// https://en.wikipedia.org/wiki/Bubble_sort
// https://en.wikipedia.org/wiki/Selection_sort
// https://en.wikipedia.org/wiki/Insertion_sort
// https://www.wikiwand.com/en/articles/Merge_sort
// https://www.wikiwand.com/en/articles/Heapsort
// https://www.wikiwand.com/en/articles/Quicksort
// https://www.wikiwand.com/en/articles/Timsort
// https://www.wikiwand.com/en/articles/Introsort
// https://www.wikiwand.com/en/articles/Counting_sort
// https://www.wikiwand.com/en/articles/Bucket_sort
// https://www.wikiwand.com/en/articles/Radix_sort
// https://www.wikiwand.com/en/articles/Shellsort

// Samling med forskjellige sorteringsalgoritmer
public class SortInt {
    private static int tmp;
   
    public static void swap(int[] arr, int i0, int i1) {
        tmp = arr[i0];
        arr[i0] = arr[i1];
        arr[i1] = tmp;
    }

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

    // Selection (utvalgssortering / plukksortering) - Best: n^2 / Avg: n^2 / Worst: n^2 / Mem: 1 / Stable: No / In-place: Yes / Method: Selection / Parallel: ?
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

    // Insertion (Sortering ved innsetting) - Best: n / Avg: n^2 / Worst: n^2 / Mem: 1 / Stable: Yes / In-place: Yes / Method: Insertion / Parallel: ?
    public static void insertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int j = i;
            while (j > 0 && arr[j-1] > val) {
                arr[j] = arr[j-1];
                j -= 1;
            }
            arr[j] = val;
        }
    }


    ////////////////////////////////////////////////////////////////////////////////
    // Efficient
    ////////////////////////////////////////////////////////////////////////////////
    // Shell (Shellsortering) - Best n log n / Avg: omega(n log n) / Worst: n log^2 n / Mem: 1 / Stable: No / In-place: Yes / Method: Insertion / Parallel: ?
    private static final int[][] shell_gaps = new int[][] {
        {701, 301, 132, 57, 23, 10, 4, 1}, // Ciura, 2001
        {1049, 347, 113, 37, 11, 3, 1},    // Rhoads, 2010
        {512, 230, 102, 45, 20, 9, 4, 1},  // Skean, Ehrenborg, Jaromczyk, 2023
    };
    public static void shell(int[] arr) {
        shell(arr, 0);
    }
    public static void shell(int[] arr, int seq) {
        for (int gap : shell_gaps[seq % shell_gaps.length]) {
            for (int i = gap; i < arr.length; i += 1) {
                tmp = arr[i];
                int j = i;
                for (; (j >= gap) && (arr[j - gap] > tmp); j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = tmp;
            }
        }
    }

    // Merge (Flettesortering) - Best: n log n / Avg: n log n / Worst: n log n / Mem: n / Stable: Yes / In-place: No / Method: Merging / Parallel: Yes
    public static void merge(int[] arr) {
        int[] aux = Arrays.copyOf(arr, arr.length);
        merge(arr, aux, 0, arr.length - 1);
    }

    private static void merge(int[] arr, int[] aux, int lo, int hi) {
        if (hi <= lo) { return; }
        int mid = lo + ((hi - lo) / 2);
        merge(arr, aux, lo, mid);
        merge(arr, aux, mid+1, hi);
        int i = lo;
        int k = lo;
        for (int j = mid+1; i <= mid && j <= hi; k++) { aux[k] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++]; }
        while(i <= mid) { aux[k++] = arr[i++]; }
        for (i = lo; i <= hi; i++) { arr[i] = aux[i]; }
    }

    // Heap (Haugsortering (forbedret versjon av utvalgssortering)) - Best: n log n / Avg: n log n / Worst: n log n / Mem: 1 / Stable: No / In-place: Yes / Method: Selection / Parallel: ?
    public static void heap (int[] arr) {
        for (int i = (arr.length - 2) / 2; i >= 0; i--) { heapify(arr, i, arr.length); }
        for (int i = arr.length; i > 0; i--) {
            tmp = arr[0];
            arr[0] = arr[i-1];
            arr[i-1] = tmp;
            heapify(arr, 0, i-1);
        }
    }

    private static void heapify(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = (left < size && arr[left] > arr[i]) ? left : i;
        if (right < size && arr[right] > arr[max]) { max = right; }
        if (max != i) {
            tmp = arr[i];
            arr[i] = arr[max];
            arr[max] = tmp;
            heapify(arr, max, size);
        }
    }

    // Quick, Lomoto partition scheme (Kvikksortering) - Best: n log n / Avg: n log n / Worst: n^2 / Mem: log n / Stable: No / In-place: Yes / Method: Partitioning / Parallel: ?
    public static void quick_lomoto(int[] arr) {
        if (arr.length > 1) { quick_lomoto(arr, 0, arr.length - 1); }
    }

    private static void quick_lomoto(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int p = lo; // Pivot index
            for (int i = lo; i < hi; i++) {
                if (arr[i] <= arr[hi]) { // Pivot -> arr[hi]
                    tmp = arr[i];
                    arr[i] = arr[p];
                    arr[p] = tmp;
                    p += 1;
                }
            }
            tmp = arr[hi];
            arr[hi] = arr[p];
            arr[p] = tmp;
            quick_lomoto(arr, lo, p-1);
            quick_lomoto(arr, p+1, hi);
        }
    }
    
    // Quick, Hoare partition scheme (Kvikksortering) - Best: n log n / Avg: n log n / Worst: n^2 / Mem: log n / Stable: No / In-place: Yes / Method: Partitioning / Parallel: ?
    public static void quick_hoare(int[] arr) {
        if (arr.length > 1) { quick_hoare(arr, 0, arr.length - 1); }
    }
    
    private static void quick_hoare(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int i = lo - 1;
            int j = hi + 1;
            while (true) {
                do { i += 1; } while (arr[i] < arr[lo]); // Pivot -> arr[lo]
                do { j -= 1; } while (arr[j] > arr[lo]); // Pivot -> arr[lo]
                if (i >= j) { break; }
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            quick_hoare(arr, lo, j);
            quick_hoare(arr, j+1, hi);
        }
    }

    public static void quick_dutch_flag(int[] arr) {
        if (arr.length > 1) { quick_dutch_flag(arr, 0, arr.length - 1); }
    }
    
    private static void quick_dutch_flag(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pivot = arr[hi];
            int i = lo;
            int j = lo;
            int k = hi;
            while (j <= k) {
                if (arr[j] < arr[hi]) { // Pivot -> arr[hi]
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i += 1;
                    j += 1;
                }
                else if (arr[j] > arr[hi]) { // Pivot -> arr[hi]
                    tmp = arr[k];
                    arr[k] = arr[j];
                    arr[j] = tmp;
                    k -= 1;
                }
                else { j += 1; }
            }
            quick_dutch_flag(arr, lo, i-1);
            quick_dutch_flag(arr, j, hi);
        }
    }


    ////////////////////////////////////////////////////////////////////////////////
    // Distribution
    ////////////////////////////////////////////////////////////////////////////////
    // Counting - Best: - / Avg: n+r / Worst: n+r / Mem: n+r / Stable: Yes / In-place: Yes / Parallel: ?
    public static void counting(int[] arr) {
        Map<Integer, Integer> freq = new TreeMap<>();
        for (int n : arr) { freq.put(n, freq.getOrDefault(n, 0) + 1); }
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int key = entry.getKey();
            for (int val = entry.getValue(); val > 0; val--) { arr[i++] = key; }
        }
    }

    // LSD Radix - Best: n / Avg: n*k/d / Worst: n*k/d / Mem: n+2^d / Stable: Yes / In-place: No / Parallel: ?
    // MSD Radix - Best: n / Avg: n*k/d / Worst: n*k/d / Mem: n+2^d / Stable: Yes / In-place: No / Parallel: ?

    ////////////////////////////////////////////////////////////////////////////////
    // Hybrid
    ////////////////////////////////////////////////////////////////////////////////
    // Tim - Best: n / Avg: n log n / Worst: n log n / Mem: n / Stable: Yes / In-place: No / Method: Insertion & Merging / Parallel: ?
    // Intro - Best: n log n / Avg: n log n / Worst: n log n / Mem: log n / Stable: No / In-place: Yes / Method: Partitioning & Selection (Quicksort & heapsort) / Parallel: ?

}
