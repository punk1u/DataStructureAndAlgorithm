package tech.punklu.algorithm.search;

/**
 * 二分查找最后一个小于等于给定值的元素下标
 */
public class BinarySearchFindingLastLowerIndex {

    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                /**
                 * 与查找第一个大于等于给定值元素下标的二分查找类似，
                 * 当mid处的值小于等于给定值时，需要判断mid后面的值是否依然小于等于给定的值，
                 * 因此当mid等于最后一个元素无法继续向后遍历时，或者mid后一个元素比给定值大时，
                 * 说明mid即是最后一个小于等于给定值的元素下标，直接返回。否则，继续向后遍历，
                 * 直到找到最后一个小于等于给定元素值的下标时返回。
                 */
                if ((mid == n - 1) || (a[mid + 1] > value)) return mid;
                else low = mid + 1;
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
