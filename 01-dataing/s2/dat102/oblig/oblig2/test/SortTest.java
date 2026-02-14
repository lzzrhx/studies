package test;

import src.Sort;
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

public class SortTest {
    @Test
    void test() {
        int[] tab_unsorted = new int[] {7,2,3,5,0,4,10,1,9,6,8};
        int[] tab_sorted   = new int[] {0,1,2,3,4,5,6,7,8,9,10};
        int[] tab;

        // Bubble
        tab = Arrays.copyOf(tab_unsorted, tab_unsorted.length);
        Sort.bubble(tab);
        assertArrayEquals(tab_sorted, tab);
    
        // Selection
        tab = Arrays.copyOf(tab_unsorted, tab_unsorted.length);
        Sort.selection(tab);
        assertArrayEquals(tab_sorted, tab);
        
        // Insertion
        tab = Arrays.copyOf(tab_unsorted, tab_unsorted.length);
        Sort.insertion(tab);
        assertArrayEquals(tab_sorted, tab);
        
        // Heap
        // Merge
        // Quick
        // Tim
        // Intro
        // Counting
        // MSD Radix
    }
}
