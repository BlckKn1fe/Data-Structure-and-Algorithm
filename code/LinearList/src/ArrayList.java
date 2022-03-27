/**
 * @author BlackKnife lding1003@gmail.com
 */
public class ArrayList<T> {

    private Object[] data;
    private final int capacity;
    private int len;

    /**
     * 默认初始化大小 100
     */
    public ArrayList() { this(100); }

    /**
     * 根据传入 size 大小初始化数组大小
     * @param capacity
     */
    public ArrayList(int capacity) {
        if (capacity < 0) throw new RuntimeException("Illegal size");
        else {
            this.data = new Object[capacity];
            this.capacity = capacity;
            this.len = 0;
        }
    }

    /**
     * 获取 index 位置的元素
     * @param index 目标索引
     * @return 目标元素
     */
    public T get(int index) {
        if (index < 0 || index >= this.len) return null;
        return (T)this.data[index];
    }

    /**
     * 添加元素到 Array 末尾
     * @param element 添加的元素
     * @return 添加结果
     */
    public boolean add(T element) {
        if (this.len == this.capacity) return false; // 添加失败，满了
        if (element == null) return false; // 不允许添加 null

        this.data[len] = element;
        this.len++;
        return true; // 添加成功
    }

    /**
     * 在 index 位置插入一个元素
     * @param index 插入的元素的目标索引
     * @param element 插入的元素
     * @return 添加结果
     */
    public boolean insert(int index, T element) {
        if (this.len == this.capacity) return false; // 先确保有空间可以条件
        if (index < 0 || index >= this.len) return false; // 检查 index 是否合法

        if (element == null) return false; // 排除 element 为 null 的情况
        for (int i = this.len; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = element;
        this.len++;
        return true;
    }

    /**
     * 返回目标元素索引值
     * @param element 目标元素
     * @return 目标元素索引值
     */
    public int indexOf(T element) {
        if (element != null && this.len > 0) {
            for (int i = 0; i < this.len; i++) {
                if (element.equals(this.data[i])) return i;
            }
        }
        return -1;
    }

    /**
     * 根据索引删除特定元素
     * @param index 想要删除的元素的索引
     * @return 返回被删除的元素
     */
    public T delete(int index) {
        if (index < 0 || index >= this.len) throw new RuntimeException("Index Out of Bounce");

        T element = (T)this.data[index];
        for (int i = index + 1; i < len; i++) {
            this.data[i - 1] = this.data[i];
        }
        this.data[len - 1] = null;
        len--;
        return element;
    }

    /**
     * 清空数组，也可以直接把 len 设置为 0，不重新创建数组对象
     */
    public void clear() {
        this.data = new Object[this.capacity];
        this.len = 0;
    }

    /**
     * 判断数组是否为空
     * @return 为空则返回 true，反之为 false
     */
    public boolean isEmpty() { return this.len == 0; }

    /**
     * 获取当前数组内元素的个数
     * @return 元素个数
     */
    public int length() { return this.len; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (this.len > 0) {
            sb.append(this.data[0]);
            for (int i = 1; i < this.len; i++) {
                sb.append(", ").append(this.data[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
