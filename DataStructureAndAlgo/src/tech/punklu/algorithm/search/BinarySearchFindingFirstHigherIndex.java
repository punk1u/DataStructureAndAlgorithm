package tech.punklu.algorithm.search;

/**
 * 二分查找第一个大于等于给定值的元素
 */
public class BinarySearchFindingFirstHigherIndex {

    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] >= value) {
                /**
                 * 当mid处的值大于等于给定值时，需要判断mid前面的值是否依然大于给定的值，
                 * 因此当mid等于0无法继续向前遍历时，或者mid前一个元素比给定值大时，
                 * 说明mid即是第一个比给定值大的元素下标，直接返回。否则，继续向前遍历，
                 * 直到找到第一个大于给定元素值的下标时返回。
                 */
                if ((mid == 0) || (a[mid - 1] < value)) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
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
