package tech.punklu.leetcode;

/**
 *
 * 给定一个非负整数c，你要判断是否存在两个整数 a 和 b，使得a*a + b*b = c 。
 *
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 *
 * 示例 2：
 * 输入：c = 3
 * 输出：false
 *
 * 示例 3：
 * 输入：c = 4
 * 输出：true
 *
 * 示例 4：
 * 输入：c = 2
 * 输出：true
 *
 * 示例 5：
 * 输入：c = 1
 * 输出：true
 *
 * 提示：
 * 0 <= c <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 65 536
 */
public class LC633 {

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了96.61%的用户
     * 内存消耗：35 MB, 在所有 Java 提交中击败了87.59%的用户
     * @param c
     * @return
     */
    public static boolean judgeSquareSum(int c) {
        boolean result = false;
        int begin = 0;
        int end = (int)Math.sqrt(c);
        while (begin <= end){
            int sum = (begin * begin) + (end * end);
            if (sum > c){
                end -= 1;
            }else if (sum < c){
                begin +=1;
            }else if ( sum == c){
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int c = 1000000;
        boolean result = judgeSquareSum(c);
        System.out.println(result);
    }
}
