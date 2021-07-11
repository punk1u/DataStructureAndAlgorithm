package tech.punklu.leetcode;

/**
 * 搜索旋转排序数组
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ...,
 * nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 *
 *
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 *
 * 示例2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 *
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 *
 * 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC33 {

    /**
     * 解题思路：
     * 首先找到旋转点的下标，
     * 然后判断给定要找的元素值在前后两截数据中的哪一段里，
     * 对找出来的一截有序数据进行二分查找，查找到则返回对应下标值，
     * 否则返回-1。二分查找时间复杂度O(logn)
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.7 MB, 在所有 Java 提交中击败了70.84%的用户
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int revolvePoint = -1;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i+1] < nums[i]){
                revolvePoint = i+1;
            }
        }
        int result = -1;
        if (revolvePoint == -1){
            result = bserach(nums,0,nums.length-1,target);
        }else if (revolvePoint == 0){
            if (nums[0] == target){
                result = 0;
            }else {
                result = bserach(nums,1,nums.length-1,target);
            }
        }else if (nums[revolvePoint-1] >= target && nums[0] <=target){
            result = bserach(nums,0,revolvePoint-1,target);
        }else {
            result = bserach(nums,revolvePoint,nums.length-1,target);
        }
        return result;

    }

    /**
     * 二分查找方法，对给定的数组的low-high坐标之间的数据进行二分查找，
     * 时间复杂度O(logn)
     * @param nums
     * @param low
     * @param high
     * @param target
     * @return
     */
    private static int bserach(int[] nums,int low,int high,int target){
        while (low <= high){
            int mid = low + (high - low)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                low = mid + 1;
            }else if (nums[mid] > target){
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int result = search(nums,-1);
        System.out.println(result);
    }
}
