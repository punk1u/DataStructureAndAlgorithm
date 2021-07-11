package tech.punklu.algorithm.search;

/**
 * 简单的二分查找，只要找到给定的值就返回
 *
 * 时间复杂度O(logn)
 */
public class SimpleBinarySearch {

    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        // 是low <= high，而不是low < high
        while (low <= high) {
            // 防止溢出，不要写(low+high)/2，为了实现最大性能优化，可以使用low+((high-low)>>1) 位运算
            int mid = low+(high-low)/2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                // 防止死循环，应该是 mid+1
                low = mid + 1;
            } else {
                // 防止死循环，应该是 mid-1
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int index = bsearch(arr,10,5);
        System.out.println(arr[index]);
    }
}
