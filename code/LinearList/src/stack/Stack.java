package stack;

public interface Stack<T> {
    boolean isEmpty();
    boolean push(T data);
    T peek();
    T pop();
    void clear();
}
