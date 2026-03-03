package src;

import java.util.Arrays;
import java.util.EmptyStackException;

// Stabel implementasjon som bruker tabell
public class Stack<T> implements StackADT<T> {    
    // Klassevariabler
    private static final int DEF_CAP = 10;

    // Objektvariabler
    private T[] stack;
    private int sc;
    private int initial_cap;
    private boolean debug;

    // Konstruktør
    public Stack() {
        this(DEF_CAP);
    }

    // Konstruktør
    public Stack(boolean debug) {
        this.debug = debug;
        this();
    }

    // Konstruktør
    public Stack(int cap) {
        if (debug) { System.out.printf("New [Stack] object created with capacity %s.%n", cap); }
        this.initial_cap = cap;
        clear();
    }
    
    // Konstruktør
    public Stack(int cap, boolean debug) {
        this.debug = debug;
        this(cap);
    }
    
    // Push til stabel
    @Override
    public void push(T item) {
        if (item != null) {
            if (sc + 1 > stack.length) { stack = Arrays.copyOf(stack, (int)(1.5 * stack.length)); }
            stack[sc++] = item;
            if (debug) { System.out.printf("Item \"%s\" pushed to stack. Current stack counter: %d.%n", item, this.sc); }
        }
    }

    // Les av øverste verdi fra stabel
    @Override
    public T peek() {
        return isEmpty() ? null : stack[sc-1];
    }

    // Les av og fjern øverste verdi fra stabel
    @Override
    public T pop() {
        if (isEmpty()) {
            if (debug) { System.out.printf("Warning! Attempted to pop from empty stack!%n"); }
            return null;
        }
        T item = stack[sc---1];
        stack[sc] = null;
        if (debug) { System.out.printf("Item \"%s\" popped from the stack. Current stack counter: %d.%n", item, this.sc); }
        return item;
    }

    // Sjekk om stabel er tom
    @Override
    public boolean isEmpty() {
        return sc == 0;
    }

    // Tøm stabel
    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        this.stack = (T[]) new Object[initial_cap];
    }
}
