package tech.punklu.algorithm.sort;

/**
 * 快速排序
 *
 * 总体上，快速排序是遵循分治思想的，也就是大问题划分为小问题。
 *
 * 1）大问题划分为小问题
 * 快速排序与插入、冒泡等的区别，就是对输入的序列做划分。以数组A[p..r]为例，选择一个元素pivot作为分区节点完成划分后，左边分区是小于pivot的元素，右边是大于等于pivot的元素，中间是分区节点pivot。
 *
 * 2）解决小问题
 * 每次划分结束，对左右分区继续递归快排，中间分区不再处理。
 * 这里可以看到，每次划分实际上就是排序。其中，中间分区（节点pivot）排序完成，左右分区继续快排。
 *
 * 3）合并得到大问题的解
 * 在当前的数组例子中，所有的分区快排都在原址上进行，不需要额外合并处理。
 *
 * 因为分区的过程涉及交换操作，如果数组中有两个相同的元素，比如序列6，8，7，6，3，5，9，4，
 * 在经过第一次分区操作之后，两个6的相对先后顺序就会改变。所以，快速排序并不是一个稳定的排序算法。
 *
 * 快速排序是原地排序算法，借助分区的方式，可以实现原地交换元素进行排序。
 *
 * 每次分区极其均衡的情况下，即最好时间复杂度为O(nlogn），但是当数据比较极端时，
 * 比如如果数组中的数据原来已经是有序的了，比如1，3，5，6，8。
 * 如果我们每次选择最后一个元素作为pivot，那每次分区得到的两个区间都是不均等的。
 * 我们需要进行大约n次分区操作，才能完成快排的整个过程。
 * 每次分区我们平均要扫描大约n/2个元素，这种情况下，快排的时间复杂度就从O(nlogn)退化成了O(n^2)。
 *
 * T(n)在大部分情况下的时间复杂度都可以做到O(nlogn)，只有在极端情况下，才会退化到O(n2)。
 */
public class QuickSort {

    /**
     * 数组内元素交换
     * @param nums 输入数组
     * @param i 元素1下标
     * @param j 元素2下标
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums [i];
        nums [i] = nums [j];
        nums [j] = temp;
    }

    /**
     * 快速排序
     *
     * 每次都选择给定数组中的指定边界中的最右侧元素作为判断依据值，
     * 比这个依据值更小的放在左侧，比这个依据值更大的放在右侧。
     * 这样便完成了对指定边界范围内的以这个依据值为判断条件的左右排列，
     * 然后再采用分治思想，将给定边界向两侧的更小边界不断缩小，
     * 直到最后排列完全部元素，此时也就完成了所有元素的排列
     *
     * @param nums 输入数组
     * @param left 划分左边界
     * @param right 划分右边界
     */
    private static void quickSort(int[] nums, int left, int right) {
        // 递归返回条件，和分区排序结束
        if (right-left <=0) {
            return;
        }
        // 选择数组右边界值作为分区节点
        int pivot = nums[right];
        // 从数组左边界值开始维护分区
        int partition=left-1;
        // 遍历当前分区内元素
        for (int i = left; i <= right-1; i++) {
            if ((nums [i] < pivot) ) {
                // 将小于pivot的值交换到partition左边
                // 将大于等于pivot的值交换到partition右边
                partition++;
                swap(nums, partition, i);
            }
        }
        // 将分区节点插入到数组左右分区中间
        partition++;
        swap(nums, partition, right);
        // 分区节点排序完成
        // 左分区继续排序，右分区继续排序
        quickSort(nums,left, partition-1);
        quickSort(nums,partition+1, right);
    }

    /**
     * 排序数组入口函数
     *
     * @param nums 输入数组
     * @return 返回完成排序的数组
     */
    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length ==0) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }


    public static void main(String[] args) {
        int[] a = {6,2,4,3,5,1};
        sortArray(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
