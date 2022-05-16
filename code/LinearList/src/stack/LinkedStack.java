package stack;

import stack.Stack;

/**
 * @author BlackKnife lding1003@gmail.com
 */
public class LinkedStack<T> implements Stack<T> {

    /**
     * 使用 Node 内部类来作为结点储存数据
     * @param <T>
     */
    private static class Node<T> {
        T e; // 数据域
        Node<T> next; // 指针域

        public Node(T e) {
            this.e = e;
        }

        public Node(T e, Node<T> next) {
            this.e = e;
            this.next = next;
        }
    }

    private Node<T> top;
    private int length;

    public LinkedStack() {
        this.top = null;
        this.length = 0;
    }

    /**
     * 添加元素使用尾插法，设置新的 Node 的 next 为 top，然后修改 top 指向为新的 Node
     * @param element 被压栈的元素
     * @return 成功压栈返回 true（假设链表实现的 Stack 空间无限）
     */
    public boolean push(T element) {
        Node<T> n = new Node<>(element);
        n.next = top;
        top = n;
        length++;
        return true;
    }

    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty!");
        T element = top.e;
        top = top.next;
        length--;
        return element;
    }

    public T peek() {
        if (top == null) throw new RuntimeException("Stack is empty!");
        return top.e;
    }

    /**
     * 在 C/C++ 的实现里需要手动释放内存
     */
    public void clear() {
        top = null;
        length = 0;
    }
    public boolean isEmpty() { return top == null; }

    public int length() { return length; }
}
