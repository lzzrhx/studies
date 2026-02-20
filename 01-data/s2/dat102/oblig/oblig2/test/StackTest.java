package test;

import src.StackADT;
import src.Stack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//assertTrue();
//assertFalse();
//assertEquals(expected, actual);
//assertArrayEquals(expected, actual);
//assertNull();
//assertNotNull();
//assertSame(a, b);
//assertNotSame(a, b);

public class StackTest {
    @Test
    void test() {
        StackADT<Integer> stack = new Stack<>();
        assertTrue(stack.isEmpty());
        assertNull(stack.pop());
        assertNull(stack.peek());
        for (int i = 0; i < 20; i++) { stack.push(i); }
        assertFalse(stack.isEmpty());
        assertEquals(19, stack.pop());
        assertEquals(18, stack.peek());
        for (int i = 0; i < 25; i++) { stack.pop(); }
        assertTrue(stack.isEmpty());
        assertNull(stack.pop());
        assertNull(stack.peek());
    }
}
