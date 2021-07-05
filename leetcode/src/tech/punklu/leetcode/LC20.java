package tech.punklu.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 *
 * 示例2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例4：
 * 输入：s = "([)]"
 * 输出：false
 *
 * 示例5：
 * 输入：s = "{[]}"
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC20 {

    private static final Map<Character,Character> map = new HashMap();

    static {
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
    }

    /**
     * 栈 思路解决
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character>stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c=='('){
                stack.push(')');
            }else if(c=='['){
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }else if(stack.isEmpty()||c!=stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s = "()[]{}";
        boolean result = isValid(s);
        System.out.println(result);
    }
}
