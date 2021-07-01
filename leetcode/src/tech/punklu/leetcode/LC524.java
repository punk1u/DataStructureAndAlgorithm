package tech.punklu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 *
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 *
 *
 * 示例 1：
 *
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 *
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 *
 * 提示：
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC524 {

    /**
     * 执行用时：26 ms, 在所有 Java 提交中击败了64.97%的用户
     * 内存消耗：39.2 MB, 在所有 Java 提交中击败了79.50%的用户
     * @param s
     * @param dictionary
     * @return
     */
    public static String findLongestWord(String s, List<String> dictionary) {
        String longtestString = "";
        for (String item : dictionary) {
            if (isSubString(s,item)){
                if (item.length() > longtestString.length()){
                    longtestString = item;
                    continue;
                }else if (item.length() == longtestString.length() && item.compareTo(longtestString) < 0){
                    longtestString = item;
                    continue;
                }

            }
        }
        return longtestString;
    }

    /**
     * 判断传入的第一个字符串是否是第二个字符串的子串
     * @param s
     * @param target
     * @return
     */
    private static boolean isSubString(String s,String target){
        int i = 0;
        int j = 0;
        while (i < s.length()  && j< target.length()){
            if (s.charAt(i) == target.charAt(j)){
                j++;
            }
            i++;
        }
        return j == target.length();
    }

    public static void main(String[] args) {
        String s= "abce";
        List<String> dictionary = Arrays.asList("abe","abc");
        System.out.println(findLongestWord(s,dictionary));

    }

}
