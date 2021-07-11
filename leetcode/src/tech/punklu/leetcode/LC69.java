package tech.punklu.leetcode;

/**
 * 实现int sqrt(int x)函数。
 *
 * 计算并返回x的平方根，其中x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC69 {

    /**
     * 使用二分查找法，查找最后一个满足left * left <= x的left值
     * 二分查找时间复杂度O(logn)
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int x = 24;
        int result = mySqrt(x);
        System.out.println(result);
    }
}
