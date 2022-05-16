package queue;

import queue.Queue;

/**
 * @author BlackKnife lding1003@gmail.com
 */
// TODO: 添加 ensureCapacity
public class SeqQueue<T> implements Queue<T> {
    private final static int DEFAULT_SIZE = 100;

    private Object[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    /**
     * 默认初始化 Queue 大小 100
     */
    public SeqQueue() {
        data = new Object[DEFAULT_SIZE];
        this.capacity = DEFAULT_SIZE;
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    /**
     * 添加元素进队列，如果满了则添加失败
     * @param data
     * @return 当成功添加时返回 true，反之 false
     */
    @Override
    public boolean add(T data) {
        if (size == capacity) return false;
        this.data[rear] = data;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }

    /**
     * 获取队列头的元素，但是不会移除它
     * @return 队列头的元素
     */
    @Override
    public T peek() {
        if (isEmpty()) return null;
        return (T)this.data[front];
    }

    /**
     * 获取元素队列头的元素，并且移除它
     * @return 队列头的元素
     */
    @Override
    public T remove() {
        if (isEmpty()) return null;
        T data = (T)this.data[front];
        front = (front + 1) % capacity;
        size--;
        return data;
    }

    /**
     * 清空队列
     */
    public void clear() {
        front = 0;
        rear = 0;
        size = 0;
        data = new Object[DEFAULT_SIZE];
    }

    /**
     * 获取队列内元素个数
     * @return 队列内元素个数
     */
    public int size() { return size; }

    /**
     * 判断队列是否为空
     * @return 当队列为空时返回 true，反之 false
     */
    public boolean isEmpty() { return size == 0; }

}
