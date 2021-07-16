package tech.punklu.leetcode;

import java.util.Arrays;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 *
 * 示例2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 *
 * 输入：nums = [10]
 * 输出："10"
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC179 {

    /**
     * 将int数组转为字符串数组，然后根据其ASCII码对其进行从大到小排序，然后输出即可。
     * @param nums
     * @return
     */
    public static String largestNumber(int[] nums) {
        int n = nums.length;
        if (n == 1) return String.valueOf(nums[0]);
        /**
         * 转换为字符串数组
         */
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        /**
         * 对字符串数组进行排序
         * a.compareTo(b)：是从头开始比较对应字符的大小(ASCII码顺序)
         * 如果a的第一个字符和b的第一个字符不等，结束比较，返回他们之间的长度差值
         * 如果a的第一个字符和b的第一个字符相等，则a的第二个字符和b的第二个字符做比较
         * 以此类推,直至比较的字符或被比较的字符有一方结束。
         *
         * Array.sort()中如果使用自定义比较器Comparator
         * 规则是对于参与比较的两个元素(a,b)而言，若返回值为正数则说明发生交换
         * 当前比较器规则为(b+a).compareTo(a+b),如果大于0,Comparator接收返回值为正数，就会交换a和b
         */
        Arrays.sort(arr, ((o1, o2) -> (o2+o1).compareTo(o1+o2)));
        StringBuilder sb = new StringBuilder();
        /**
         * 元素中可能含有值为0的元素，定位到第一个非0元素
         */
        int i = 0;
        while (i < n && arr[i].equals("0")) {
            i++;
        }
        while (i < n) {
            sb.append(arr[i++]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = {3,30,34,5,9};
        System.out.println(largestNumber(arr));
    }
}
