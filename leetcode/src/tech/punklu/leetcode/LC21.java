package tech.punklu.leetcode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC21 {

     public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode cursor = result;
        while (l1 != null || l2 != null){
            ListNode item = new ListNode();
            int l1Value = l1 != null ? l1.val:Integer.MAX_VALUE;
            int l2Value = l2 != null ? l2.val:Integer.MAX_VALUE;
            if (l1Value <= l2Value){
                item.val = l1Value;
                l1 = l1.next;
            }else {
                item.val = l2Value;
                l2 = l2.next;
            }
            cursor.next = item;
            cursor = cursor.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        ListNode cursor1 = l1;
        cursor1.next = new ListNode(1);
        cursor1 = cursor1.next;
        cursor1.next = new ListNode(2);
        cursor1 = cursor1.next;
        cursor1.next = new ListNode(4);
        cursor1 = cursor1.next;
        ListNode l2 = new ListNode();
        ListNode cursor2 = l2;
        cursor2.next = new ListNode(1);
        cursor2 = cursor2.next;
        cursor2.next = new ListNode(3);
        cursor2 = cursor2.next;
        cursor2.next = new ListNode(4);
        cursor2 = cursor2.next;
        ListNode result = mergeTwoLists(l1.next,l2.next);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
