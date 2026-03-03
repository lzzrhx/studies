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

    // Konstruktør
    public Stack() {
        this(DEF_CAP);
    }

    // Konstruktør
    public Stack(int cap) {
        this.initial_cap = cap;
        clear();
    }
    
    // Push til stabel
    @Override
    public void push(T item) {
        if (item != null) {
            if (sc + 1 > stack.length) { stack = Arrays.copyOf(stack, (int)(1.5 * stack.length)); }
            stack[sc++] = item;
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
            return null;
        }
        T item = stack[sc---1];
        stack[sc] = null;
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
