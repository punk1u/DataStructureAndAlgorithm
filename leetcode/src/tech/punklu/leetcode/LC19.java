package tech.punklu.leetcode;

/**
 * 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC19 {


    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 双指针法
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode realHead = new ListNode(0, head);
        ListNode fast = realHead;
        ListNode slow = realHead;
        int i = 0;
        while (fast != null) {
            if (i <= n) {
                fast = fast.next;
                i++;
                continue;
            }
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return realHead.next;
    }

    public static void main(String[] args) {
        ListNode linkedList = new ListNode();
        ListNode cursor = linkedList;
        cursor.next = new ListNode(1);
        cursor = cursor.next;
        cursor.next = new ListNode(2);
        cursor = cursor.next;
        cursor.next = new ListNode(3);
        cursor = cursor.next;
        cursor.next = new ListNode(4);
        cursor = cursor.next;
        cursor.next = new ListNode(5);
        cursor = cursor.next;
        ListNode listNode = removeNthFromEnd(linkedList.next,2);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
