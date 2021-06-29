package tech.punklu.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC1 {

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了55.35%的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了96.57%的用户
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums,int target){
        int[] result = new int[2];
        Map<Integer,Integer> valueAndIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int needNum = target - nums[i];
            if (valueAndIndexMap.containsKey(needNum)){
                result[0] = valueAndIndexMap.get(needNum);
                result[1] = i;
                break;
            }
            valueAndIndexMap.put(nums[i],i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] testArray1 = {2,7,11,15};
        int[] result = twoSum(testArray1,9);
        System.out.println(result[0] + " " + result[1]);
    }

}
