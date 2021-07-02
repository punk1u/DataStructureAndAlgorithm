package tech.punklu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 *
 * 输入:
 * "cccaaa"
 *
 * 输出:
 * "cccaaa"
 *
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 *
 * 输入:
 * "Aabb"
 *
 * 输出:
 * "bbAa"
 *
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC451 {

    /**
     * 执行用时：13 ms, 在所有 Java 提交中击败了79.31%的用户
     * 内存消耗：39.2 MB, 在所有 Java 提交中击败了72.75%的用户
     * @param s
     * @return
     */
    public static String frequencySort(String s) {
        Map<Character,Integer> numAndCountMap = new HashMap<>();
        for (char c : s.toCharArray()){
            numAndCountMap.put(c,numAndCountMap.getOrDefault(c, 0) + 1);
        }
        List<Character>[] frequencyArr = new ArrayList[s.length()+1];
        for (Character c: numAndCountMap.keySet()) {
            int count = numAndCountMap.get(c);
            if (frequencyArr[count] == null){
                frequencyArr[count] = new ArrayList<>();
            }
            frequencyArr[count].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = frequencyArr.length-1; i >= 0 ; i--) {
            if (frequencyArr[i] == null){
                continue;
            }
            for (char c:frequencyArr[i]) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "Aabb";
        String result = frequencySort(s);
        System.out.println(result);
    }
}
