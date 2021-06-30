package tech.punklu.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC4 {

    /**
     * 执行用时： 5 ms, 在所有 Java 提交中击败了15.17%的用户
     * 内存消耗：39.7 MB, 在所有 Java 提交中击败了57.53%的用户
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int middleIndex = (nums1.length + nums2.length)/2;
        int remainder = (nums1.length + nums2.length)%2;
        int cursor1 = 0;
        int cursor2 = 0;
        int maxCount = middleIndex + 1;
        int lastNo = Integer.MIN_VALUE;
        int lastSecondNo = Integer.MIN_VALUE;
        while ((cursor1 + cursor2 +1) <= maxCount){
            if ((cursor1)<nums1.length && (cursor2)<nums2.length){
                if (nums1[cursor1] < nums2[cursor2]){
                    int temp = lastNo;
                    lastNo = nums1[cursor1];
                    lastSecondNo = temp;
                    cursor1 +=1;
                }else if (nums1[cursor1] >= nums2[cursor2]){
                    int temp = lastNo;
                    lastNo = nums2[cursor2];
                    lastSecondNo = temp;
                    cursor2 +=1;
                }
            }else if ((cursor1)<nums1.length){
                int temp = lastNo;
                lastNo = nums1[cursor1];
                lastSecondNo = temp;
                cursor1 +=1;
            }else if ((cursor2)<nums2.length){
                int temp = lastNo;
                lastNo = nums2[cursor2];
                lastSecondNo = temp;
                cursor2 +=1;
            }
        }


        if (remainder == 1){
            return lastNo;
        }else {
            Double sum = 0.00d;
            sum += Double.valueOf(String.valueOf(lastNo));
            sum += Double.valueOf(String.valueOf(lastSecondNo));
            return sum/2;
        }
    }

    public static void main(String[] args) {
        int[] a1 = {2};
        int[] a2 = {};
        double res = findMedianSortedArrays(a1,a2);
        System.out.println(res);
    }
}
