package tech.punklu.datastructure.linearlist;

/**
 * 基于数组的循环队列
 *
 * 循环队列最重要的即是判断队列是否已满的条件：(tail+1)%n == head ,
 * 其中tail为尾节点的位置，n为数组大小，head为头节点的位置
 */
public class CircularQueue {

    /**
     * 数组
     */
    private String[] items;
    /**
     * 数组大小：n
     */
    private int n = 0;
    /**
     * 表示队头下标
     */
    private int head = 0;
    /**
     * 表示队尾下标
     */
    private int tail = 0;

    /**
     * 申请一个大小为capacity的数组
     * @param capacity
     */
    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        // 队列满了
        if ((tail + 1) % n == head) return false;
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public String dequeue() {
        // 如果head == tail 表示队列为空
        if (head == tail) return null;
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }
}
