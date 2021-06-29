package tech.punklu.leetcode;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 *
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC2 {

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.99%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了99.67%的用户
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode cursor = result;
        boolean moveFlag = false;
        while (l1 != null || l2 != null || moveFlag){
            ListNode item = new ListNode();
            int sum = 0;
            if (l1 != null){
                sum =  sum + l1.val;
            }
            if (l2 != null){
                sum =  sum + l2.val;
            }
            if (moveFlag){
                sum +=1;
            }
            if (sum >= 10){
                sum = sum - 10;
                moveFlag = true;
            }else {
                moveFlag = false;
            }
            item.val = sum;

            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
            cursor.next = item;
            cursor = item;
        }
        return result.next;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        ListNode cur1 = l1;
        for (int i = 0; i < 7; i++) {
            cur1.next = new ListNode(9);
            cur1 = cur1.next;
        }

        ListNode l2 = new ListNode();
        ListNode cur2 = l2;
        for (int i = 0; i < 4; i++) {
            cur2.next = new ListNode(9);
            cur2 = cur2.next;
        }

        ListNode result = addTwoNumbers(l1.next,l2.next);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }


    }
}
