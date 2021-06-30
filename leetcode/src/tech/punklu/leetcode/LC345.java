package tech.punklu.leetcode;

import java.util.*;

/**
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 *
 * 示例 1：
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入："leetcode"
 * 输出："leotcede"
 *
 * 提示：
 *
 * 元音字母不包含字母 "y" 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class LC345 {

    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    /**
     * 使用双指针，时间复杂度O(n)，空间复杂度O(1)
     *
     * 执行用时：5 ms, 在所有 Java 提交中击败了44.90%的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了94.77%
     * 的用户
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        char[] stringChar = new char[s.length()];
        int i = 0;
        int j = s.length()-1;
        while (i <= j){
            char firstChar = s.charAt(i);
            char endChar = s.charAt(j);
            if (vowels.contains(firstChar) && vowels.contains(endChar)){
                stringChar[i] = endChar;
                stringChar[j] = firstChar;
                i++;
                j--;
            }
            if (!vowels.contains(firstChar)){
                stringChar[i] = firstChar;
                i++;
            }
            if (!vowels.contains(endChar)){
                stringChar[j] = endChar;
                j--;
            }
        }
        return new String(stringChar);
    }

    public static void main(String[] args) {
        String string = " ";
        String result = reverseVowels(string);
        System.out.println(result);
    }
}
