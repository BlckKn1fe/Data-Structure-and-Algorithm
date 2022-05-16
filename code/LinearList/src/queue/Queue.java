package queue;

public interface Queue<T> {

    boolean isEmpty();
    boolean add(T data);
    T peek();
    T remove();
    void clear();
    int size();

}
