package list;

/**
 * @author BlackKnife lding1003@gmail.com
 */
public class LinkedList<E>  {
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

    private Node<E> head;  // 这个 head 不表示 “头结点”，表示 list.LinkedList 入口，即第一个元素
    private int len;

    /**
     * 空参构造，head 这里代表的是第一个元素，而不是“头结点”
     */
    public LinkedList() {
        this.head = null;
        this.len = 0;
    }

    /**
     * 私有构造函数，服务于头插法和尾插法建立 list.LinkedList
     * @param head list.LinkedList 的第一个元素的 Node 引用（reference）
     * @param len 数组长度
     */
    private LinkedList(Node<E> head, int len) {
        this.head = head;
        this.len = len;
    }

    /**
     * 头插法建立 list.LinkedList
     * @param arr 线性表元素数组
     * @param <E> 泛型
     * @return 返回基于 arr 的含有 T 类型 list.LinkedList
     */
    public static <E> LinkedList<E> headGenerate(E[] arr) {
        if (arr == null || arr.length == 0) return null;

        Node<E> p = new Node<>(arr[arr.length - 1]); // 先创建最后一个 Node
        for (int i = arr.length - 2; i >= 0; i--) {
            p = new Node<>(arr[i], p);
        }

        return new LinkedList<>(p, arr.length);
    }

    /**
     * 尾插法建立 list.LinkedList
     * @param arr 线性表元素数组
     * @param <E> 泛型
     * @return 返回基于 arr 的含有 T 类型 list.LinkedList
     */
    public static <E> LinkedList<E> tailGenerate(E[] arr) {
        if (arr == null || arr.length == 0) return null;

        Node<E> p = new Node<>(arr[0]);
        Node<E> temp = p;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node<>(arr[i]);
            temp = temp.next;
        }

        return new LinkedList<>(p, arr.length);
    }

    /**
     * 添加元素到链表末端
     * @param e 要添加的元素
     * @return 添加成功返回 true
     */
    public boolean add(E e) {
        Node<E> newNode = new Node<>(e);  // 创建新的结点
        if (head == null) {
            head = newNode;
        }
        else {
            Node<E> last = getNode(len - 1); // 获取到最后一个结点
            last.next = newNode; // 添加到最后一个结点的后面
        }
        len++;
        return true;
    }

    /**
     * 在目标索引位置插入 Node
     * @param index 目标索引
     * @param e 目标数据
     * @return 插入成功返回 true
     */
    public boolean insert(int index, E e) {
        Node<E> newNode = new Node<>(e);
        Node<E> targetNode = getNode(index);
        if (targetNode == head) {
            newNode.next = targetNode; // 如果是插在头部，则新 Node 的 next 指向当前 head 指向的 Node
            head = newNode; // 改变 head 指向，新的 Node 作为 head
        }
        else {
            Node<E> prevNode = getNode(index - 1);
            prevNode.next = newNode;
            newNode.next = targetNode;
        }
        len++;
        return true;
    }

    /**
     * 获取到索引位置的数据
     * @return 目标数据
     */
    public E get(int index) {
        return getNode(index).e;
    }

    /**
     * 删除索引位置的结点，并返回结点存储的数据
     * @param index 要删除的结点的索引
     * @return 被删除结点中的数据
     */
    public E remove(int index) {
        Node<E> targetNode = getNode(index);
        if (targetNode == head) {
            head = head.next;
        }
        else {
            Node<E> prevNode = getNode(index - 1);
            prevNode.next = targetNode.next;
        }
        targetNode.next = null;
        len--;
        return targetNode.e;
    }

    /**
     * 获得链表长度
     * @return 链表长度
     */
    public int length() { return len; }

    /**
     * 判断链表是否为空
     * @return 空则返回 true，反之则为 false
     */
    public boolean isEmpty() { return head == null && len == 0; }

    /**
     *  清空链表，这里把所有 Node 之间的 reference 全部消除
     */
    public void clear() {
        Node<E> temp;
        while (head != null) {
            temp = head.next;
            head.next = null;
            head = temp;
        }
        len = 0;
    }

    /**
     * Helper function
     * @param index 要获取的结点的 index
     * @return 目标结点
     */
    private Node<E> getNode(int index) {
        if (index >= len || index < 0) throw new RuntimeException("Illegal Index");
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    @Override
    public String toString() {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder();
        Node<E> temp = head;
        sb.append("[").append(temp.e);
        while ((temp = temp.next) != null) {
            sb.append(", ").append(temp.e);
        }
        sb.append("]");
        return sb.toString();
    }
}
