package tech.punklu.algorithm.sort;

/**
 * 归并排序
 *
 * 归并排序的核心思想还是蛮简单的。如果要排序一个数组，
 * 先把数组从中间分成前后两部分，然后对前后两部分分别排序，
 * 再将排好序的两部分合并在一起，这样整个数组就都有序了。
 *
 * 在合并的过程中，如果A[p…q]和A[q+1…r]之间有值相同的元素，
 * 可以先把A[p…q]中的元素放入tmp数组。
 * 这样就保证了值相同的元素，在合并前后的先后顺序不变。
 * 所以，归并排序是一个稳定的排序算法。
 *
 * 归并排序的时间复杂度是O(nlogn)。归并排序的执行效率与要排序的原始数组的有序程度无关，
 * 所以其时间复杂度是非常稳定的，不管是最好情况、最坏情况，还是平均情况，时间复杂度都是O(nlogn)。
 *
 * 归并排序的时间复杂度任何情况下都是O(nlogn)，看起来非常优秀。
 * （即便是快速排序，最坏情况下，时间复杂度也是O(n2)。）但是，归并排序并没有像快排那样，
 * 应用广泛，因为它不是原地排序算法。因为归并排序的合并函数，
 * 在合并两个有序数组为一个有序数组时，需要借助额外的存储空间。
 * 尽管每次合并操作都需要申请额外的内存空间，但在合并完成之后，临时开辟的内存空间就被释放掉了。
 * 在任意时刻，CPU只会有一个函数在执行，也就只会有一个临时的内存空间在使用。
 * 临时内存空间最大也不会超过n个数据的大小，所以空间复杂度是O(n)。
 *
 */
public class MergeSort {

    /**
     * 归并排序算法, a是数组，n表示数组大小
     * @param a
     * @param n
     */
    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n-1);
    }

    /**
     * 递归调用函数
     *
     * 利用分治思想，将整个数组一直不停的从中间位置分为两个子数组，
     * 每个子数组再继续分为两个更小的子数组，如此不断划分，
     * 直到最后，左右两侧的数组中都只有一个元素，然后比较这两个元素的大小，
     * 并合为一个数组，不断向上合并，将一个又一个排好序的数组不断进行合并，
     * 直到调用到最上层，将最开始分出来的两个最大的子数组合并为一个有序数组，
     * 此时，排序完成
     *
     * @param a
     * @param p
     * @param r
     */
    private static void mergeSortInternally(int[] a, int p, int r) {
        /**
         * 递归终止条件
         */
        if (p >= r) return;

        /**
         * 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
         */
        int q = p + (r - p)/2;
        /**
         * 分治递归
         */
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q+1, r);

        /**
         * 将A[p...q]和A[q+1...r]合并为A[p...r]
         */
        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        /**
         * 初始化变量i, j, k
         */
        int i = p;
        int j = q+1;
        int k = 0;
        /**
         * 申请一个大小跟a[p...r]一样的临时数组
         */
        int[] tmp = new int[r-p+1];
        while (i<=q && j<=r) {
            if (a[i] <= a[j]) {
                /**
                 * i++等于i:=i+1
                 */
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        /**
         * 判断哪个子数组中有剩余的数据
         */
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        /**
         * 将剩余的数据拷贝到临时数组tmp
         */
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        /**
         * 将tmp中的数组拷贝回a[p...r]
         */
        for (i = 0; i <= r-p; ++i) {
            a[p+i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {6,5,4,3,2,1};
        mergeSort(a,6);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
