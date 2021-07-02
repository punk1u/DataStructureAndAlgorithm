package tech.punklu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n是数组大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC347 {

    /**
     * TOPK问题
     *
     * 执行用时：14 ms, 在所有 Java 提交中击败了89.57%的用户
     * 内存消耗：40.7 MB, 在所有 Java 提交中击败了91.13%的用户
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numAndCountMap = new HashMap<>();
        for (int num : nums) {
            if (numAndCountMap.containsKey(num)){
                numAndCountMap.put(num,numAndCountMap.get(num)+1);
            }else {
                numAndCountMap.put(num,1);
            }
        }
        List<Integer>[] frequencyNumArr = new List[nums.length+1];
        for (Integer num : numAndCountMap.keySet()) {
            if (frequencyNumArr[numAndCountMap.get(num)] == null){
                List<Integer> items = new ArrayList<>();
                items.add(num);
                frequencyNumArr[numAndCountMap.get(num)] = items;
            }else {
                frequencyNumArr[numAndCountMap.get(num)].add(num);
            }
        }
        int[] res = new int[k];
        int resIndex = 0;
        for (int i = frequencyNumArr.length-1; i >0; i--) {
            if (frequencyNumArr[i] != null){
                List<Integer> items = frequencyNumArr[i];
                for (int j = 0; j < items.size(); j++) {
                    res[resIndex] = items.get(j);
                    resIndex +=1;
                }
            }
            if (resIndex >=k){
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] result = topKFrequent(nums,k);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
