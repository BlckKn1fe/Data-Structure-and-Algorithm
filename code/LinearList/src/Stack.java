/**
 * @author BlackKnife lding1003@gmail.com
 */
public class Stack<T> {

    private final Object[] data;  // 使用顺序表实现 Stack
    private final int capacity;  // 最大容积
    private final int base = 0;  // base 永远为 0
    private int top;

    /**
     * 空参构造，初始化一个容积为 100 的 Stack
     */
    public Stack() {
        this.data = new Object[100];
        this.capacity = 100;
        this.top = 0;
    }

    /**
     *
     * @param capacity Stack 容量
     */
    public Stack(int capacity) {
        this.data = new Object[capacity];
        this.capacity = capacity;
        this.top = 0;
    }

    /**
     *
     * @param element 被压栈的元素
     * @return 成功压栈返回 true，反之返回 false
     */
    public boolean push(T element) {
        if (isFull()) return false;
        data[this.top++] = element;
        return true;
    }

    /**
     * 弹栈最顶部的元素
     * @return 最顶部的元素
     */
    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty!");
        return (T)data[--top];
    }

    /**
     * 查看最顶部的元素，但是不弹栈
     * @return 最顶部的元素的值
     */
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty!");
        return (T)data[top - 1];
    }

    /**
     * 清空 Stack
     */
    public void clear() { this.top = this.base; }

    /**
     * 通过 top 和 base 做差获取 Stack 中元素个数
     * @return Stack 中元素个数
     */
    public int length() { return this.top - this.base; }

    /**
     * 判断 Stack 是否为空
     * @return 如果 Stack 为空返回 true，反之返回 false
     */
    public boolean isEmpty() { return this.top == this.base; }

    /**
     * 判断 Stack 是否满栈
     * @return 如果 Stack 满栈返回 true，反之返回 false
     */
    public boolean isFull() { return (this.top - this.base) == this.capacity; }

}
