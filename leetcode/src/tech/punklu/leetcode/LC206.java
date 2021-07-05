package tech.punklu.leetcode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC206 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 反转单链表
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode tailNode = null;
        while(head != null) {
            tailNode = new ListNode(head.val, tailNode);
            head = head.next;
        }
        return tailNode;
    }

    /**
     * 递归解法
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        //链表的最后一个node
        ListNode node = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }


    public static void main(String[] args) {
        ListNode linkedList = new ListNode(1);
        ListNode cursor = linkedList;
        cursor.next = new ListNode(2);
        cursor = cursor.next;
        cursor.next = new ListNode(3);
        cursor = cursor.next;
        cursor.next = new ListNode(4);
        cursor = cursor.next;
        cursor.next = new ListNode(5);
        cursor = cursor.next;
        ListNode result = reverseList2(linkedList);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
