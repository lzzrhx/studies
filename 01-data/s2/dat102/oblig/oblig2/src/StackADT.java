package src;

// Stabel abstract data type
public interface StackADT<T> {
    public void push(T newEntry);
    public T pop();
    public T peek();
    public boolean isEmpty();
    public void clear();
}
