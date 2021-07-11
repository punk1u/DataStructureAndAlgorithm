package tech.punklu.algorithm.search;

/**
 * 二分查找最后一个等于给定值的下标值
 */
public class BinarySearchFindingLastIndex {

    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                /**
                 * 类似于查找第一个等于给定元素值的下标的二分查找，
                 * 只需要在找到第一个等于给定元素值的下标且mid不为最后一个下标之后，
                 * 不直接返回mid，而是继续向后遍历，判断后面的元素是否等于给定元素即可。
                  */
                if ((mid == n - 1) || (a[mid + 1] != value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,5,6,8,8,8,11,18};
        int lastIndex = bsearch(arr,10,8);
        System.out.println(lastIndex + " " + arr[lastIndex]);
    }
}
