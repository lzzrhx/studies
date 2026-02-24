package test;

import src.SortInt;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

//assertTrue();
//assertFalse();
//assertEquals(expected, actual);
//assertArrayEquals(expected, actual);
//assertNull();
//assertNotNull();
//assertSame(a, b);
//assertNotSame(a, b);

public class SortIntTest {
    @Test
    void test() {
        int[][] tabs_unsorted = new int[][] {{7,2,3,5,0,4,10,1,9,6,8}, {0,3,8,7,4,5,2,1,6,9,10}, {10,1,2,3,4,5,6,7,8,9,0}};
        int[] tab_sorted   = new int[] {0,1,2,3,4,5,6,7,8,9,10};
        int[] tab;

        // Bubble
        tab = Arrays.copyOf(tabs_unsorted[0], tabs_unsorted[0].length);
        SortInt.bubble(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[1], tabs_unsorted[1].length);
        SortInt.bubble(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[2], tabs_unsorted[2].length);
        SortInt.bubble(tab);
        assertArrayEquals(tab_sorted, tab);
    
        // Selection
        tab = Arrays.copyOf(tabs_unsorted[0], tabs_unsorted[0].length);
        SortInt.selection(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[1], tabs_unsorted[1].length);
        SortInt.selection(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[2], tabs_unsorted[2].length);
        SortInt.selection(tab);
        assertArrayEquals(tab_sorted, tab);
        
        // Insertion
        tab = Arrays.copyOf(tabs_unsorted[0], tabs_unsorted[0].length);
        SortInt.insertion(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[1], tabs_unsorted[1].length);
        SortInt.insertion(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[2], tabs_unsorted[2].length);
        SortInt.insertion(tab);
        assertArrayEquals(tab_sorted, tab);
        
        // Heap
        tab = Arrays.copyOf(tabs_unsorted[0], tabs_unsorted[0].length);
        SortInt.heap(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[1], tabs_unsorted[1].length);
        SortInt.heap(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[2], tabs_unsorted[2].length);
        SortInt.heap(tab);
        assertArrayEquals(tab_sorted, tab);

        // Merge
        tab = Arrays.copyOf(tabs_unsorted[0], tabs_unsorted[0].length);
        SortInt.merge(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[1], tabs_unsorted[1].length);
        SortInt.merge(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[2], tabs_unsorted[2].length);
        SortInt.merge(tab);
        assertArrayEquals(tab_sorted, tab);

        // Quick (Lomoto)
        tab = Arrays.copyOf(tabs_unsorted[0], tabs_unsorted[0].length);
        SortInt.quick_lomoto(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[1], tabs_unsorted[1].length);
        SortInt.quick_lomoto(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[2], tabs_unsorted[2].length);
        SortInt.quick_lomoto(tab);
        assertArrayEquals(tab_sorted, tab);
        
        // Quick (Hoare)
        tab = Arrays.copyOf(tabs_unsorted[0], tabs_unsorted[0].length);
        SortInt.quick_hoare(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[1], tabs_unsorted[1].length);
        SortInt.quick_hoare(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[2], tabs_unsorted[2].length);
        SortInt.quick_hoare(tab);
        assertArrayEquals(tab_sorted, tab);
        
        // Quick (Dutch national flag)
        tab = Arrays.copyOf(tabs_unsorted[0], tabs_unsorted[0].length);
        SortInt.quick_dutch_flag(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[1], tabs_unsorted[1].length);
        SortInt.quick_dutch_flag(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[2], tabs_unsorted[2].length);
        SortInt.quick_dutch_flag(tab);
        assertArrayEquals(tab_sorted, tab);
        
        // Shell
        for (int i = 0; i < 3; i++) { 
            tab = Arrays.copyOf(tabs_unsorted[0], tabs_unsorted[0].length);
            SortInt.shell(tab, i);
            assertArrayEquals(tab_sorted, tab);
            tab = Arrays.copyOf(tabs_unsorted[1], tabs_unsorted[1].length);
            SortInt.shell(tab, i);
            assertArrayEquals(tab_sorted, tab);
            tab = Arrays.copyOf(tabs_unsorted[2], tabs_unsorted[2].length);
            SortInt.shell(tab, i);
            assertArrayEquals(tab_sorted, tab);
        }

        // Counting
        tab = Arrays.copyOf(tabs_unsorted[0], tabs_unsorted[0].length);
        SortInt.counting(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[1], tabs_unsorted[1].length);
        SortInt.counting(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[2], tabs_unsorted[2].length);
        SortInt.counting(tab);
        assertArrayEquals(tab_sorted, tab);
    }
}
