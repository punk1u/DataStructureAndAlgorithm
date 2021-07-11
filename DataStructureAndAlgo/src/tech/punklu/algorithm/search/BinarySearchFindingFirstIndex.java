package tech.punklu.algorithm.search;

/**
 * 查找第一个等于给定元素值的下标的二分查找变体
 */
public class BinarySearchFindingFirstIndex {


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
                 * 实现查找第一个等于给定元素值的下标的重点在于下面这行，
                 * 发现等于给定元素值的元素后不直接返回，而是继续进行比较当前mid之前的元素
                 * 判断前面的元素是否也等于给定元素，如果也等于，则继续向前，如果不等于或者当前mid已经等于0，
                 * 说明已遍历完成，直接返回当前mid下标
                 */
                if ((mid == 0) || (a[mid - 1] != value)) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,5,6,8,8,8,11,18};
        int firstIndex = bsearch(arr,10,8);
        System.out.println(firstIndex + " " + arr[firstIndex]);
    }
}
