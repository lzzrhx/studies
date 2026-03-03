package src;

public class Node<T> {
    T data;
    Node<T> neste;

    // Konstruktør (neste = null)
    public Node(T data) {
        this(data, null);
    }

    // Konstruktør
    public Node(T data, Node<T> neste) {
        this.data = data;
        this.neste = neste;
    }
}
