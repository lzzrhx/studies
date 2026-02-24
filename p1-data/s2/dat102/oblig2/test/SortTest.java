
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
        Integer[][] tabs_unsorted = new Integer[][] {{7,2,3,5,0,4,10,1,9,6,8}, {0,3,8,7,4,5,2,1,6,9,10}, {10,1,2,3,4,5,6,7,8,9,0}};
        Integer[] tab_sorted   = new Integer[] {0,1,2,3,4,5,6,7,8,9,10};
        Integer[] tab;
        
        // Insertion
        tab = Arrays.copyOf(tabs_unsorted[0], tabs_unsorted[0].length);
        Sort.insertion(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[1], tabs_unsorted[1].length);
        Sort.insertion(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[2], tabs_unsorted[2].length);
        Sort.insertion(tab);
        assertArrayEquals(tab_sorted, tab);
        
        // Insertion (modified)
        tab = Arrays.copyOf(tabs_unsorted[0], tabs_unsorted[0].length);
        Sort.insertionMod(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[1], tabs_unsorted[1].length);
        Sort.insertionMod(tab);
        assertArrayEquals(tab_sorted, tab);
        tab = Arrays.copyOf(tabs_unsorted[2], tabs_unsorted[2].length);
        Sort.insertionMod(tab);
        assertArrayEquals(tab_sorted, tab);
    }
}
