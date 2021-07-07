package tech.punklu.algorithm.sort;

/**
 * 快速排序
 *
 *
 */
public class QuickSort {

    /**
     * 快速排序，a是数组，n表示数组的大小
     * @param a
     * @param n
     */
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n-1);
    }

    /**
     * 快速排序递归函数，p,r为下标
     * @param a
     * @param p
     * @param r
     */
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;

        /**
         * 获取分区点
         */
        int q = partition(a, p, r);
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for(int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        return i;
    }

    public static void main(String[] args) {
        int[] a = {6,5,4,3,2,1};
        quickSort(a,6);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
