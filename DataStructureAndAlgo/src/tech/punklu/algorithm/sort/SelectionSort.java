package tech.punklu.algorithm.sort;

/**
 * 选择排序
 *
 * 选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。
 * 但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
 *
 * 选择排序空间复杂度为O(1)，是一种原地排序算法。选择排序的最好情况时间复杂度、最坏情况和平均情况时间复杂度都为O(n^2)。
 *
 * 需要注意的是，选择排序不是稳定的排序算法，比如5，8，5，2，9这样一组数据，使用选择排序算法来排序的话，
 * 第一次找到最小元素2，与第一个5交换位置，那第一个5和中间的5顺序就变了，所以就不稳定了。
 * 正是因此，相对于冒泡排序和插入排序，选择排序就稍微逊色了。
 */
public class SelectionSort {

    /**
     * 第一次遍历时，整个数组都是未排序区间，
     * 找出整个数组中的最小值，然后将找出来的最小值放在坐标0上，
     * 再继续进行遍历，此时把整个数组中第二小的元素放在坐标1上，
     * 不断遍历，直到最终完成
     * @param a
     * @param n
     */
    public static void selectionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n - 1; ++i) {
            /**
             * minIndex表示从当前未排序区间中已经找到的最小元素的下标，
             * 如果后续的迭代中找到了比已经找到的最小元素值更小的，
             * 将minIndex替换为更小元素值的下标
             */
            int minIndex = i;
            for (int j = i + 1; j < n; ++j) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            /**
             * 交换
             */
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        selectionSort(a, 6);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
