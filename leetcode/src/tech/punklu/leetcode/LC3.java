package tech.punklu.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC3 {

    /**
     * 时间复杂度为O(n*n)
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            Set<Character> appearedChars = new HashSet<>();
            int length = 1;
            appearedChars.add(s.charAt(i));
            int j = i + 1;
            while (j < s.length()){
                if (!appearedChars.contains(s.charAt(j))){
                    length +=1;
                    appearedChars.add(s.charAt(j));
                    j += 1;
                }else {
                    break;
                }

            }
            if (max < length){
                max = length;
            }

        }
        return max;
    }

    /**
     * 更优化的实现方法，时间复杂度为O(n)
     * @param s
     * @return
     */
    public static int fasterSolution(String s){
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "dvdf";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
