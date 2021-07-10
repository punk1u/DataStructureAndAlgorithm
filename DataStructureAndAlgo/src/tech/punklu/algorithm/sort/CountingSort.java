package tech.punklu.algorithm.sort;

/**
 * 计数排序
 *
 * 计数排序其实是桶排序的一种特殊情况。当要排序的n个数据，
 * 所处的范围并不大的时候，比如最大值是k，
 * 就可以把数据划分成k个桶。
 * 每个桶内的数据值都是相同的，省掉了桶内排序的时间。
 *
 *
 *
 *
 *
 * 计数排序只能用在数据范围不大的场景，如果数据范围k比要排序的数据n大很多，
 * 就不适合用计数排序了。而且，排序只能非负整数，
 * 如果要排序的数据是其他类型的，要其在不改变相对大小的情况下，转化为非负整数。
 */
public class CountingSort {

    /**
     * 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
     * @param a
     * @param n
     */
    public static void countingSort(int[] a, int n) {
        if (n <= 1) return;

        // 查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < n; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        // 申请一个计数数组c，下标大小[0,max]
        int[] c = new int[max + 1];

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i < max + 1; ++i) {
            c[i] = c[i-1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];
        // 计算排序的关键步骤了，有点难理解
        for (int i = n - 1; i >= 0; --i) {
            int index = c[a[i]]-1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将结果拷贝会a数组
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {6,5,4,3,2,1};
        countingSort(a,6);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
