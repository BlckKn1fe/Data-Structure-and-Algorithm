package queue;

public class LinkedQueue<T> implements Queue<T> {

    /**
     * 使用 Node 内部类来作为结点储存数据
     * @param <T>
     */
    private static class Node<T> {
        T data; // 数据域
        Node<T> next; // 指针域

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> head;
    private Node<T> rear;
    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(T data) {
        if (isEmpty()) {
            head = rear = new Node<>(data);
        }
        else {
            rear.next = new Node<>(data);
            rear = rear.next;
        }
        size++;
        return true;
    }

    @Override
    public T peek() {
        return head.data;
    }

    @Override
    public T remove() {
        if (isEmpty()) return null;
        T data = head.data;
        if (size == 1) {
            head = rear = null;
        }
        else {
            Node<T> temp = head;
            head = head.next;
            temp.next = null;
        }
        size--;

        return data;
    }

    @Override
    public void clear() {
        Node<T> temp = head;
        while (head != null) {
            head = head.next;
            temp.next = null;
            temp = head;
        }
        rear = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }
}
