package tech.punklu.datastructure.linearlist;

/**
 * 单链表
 */
public class LinkedList {

    ListNode head = null;

    public void insertToTail(int val){
        ListNode newNode = new ListNode(val,null);
        if (this.head == null){
            head = newNode;
        }else {
            ListNode cursor = this.head;
            while (cursor.next != null){
                cursor = cursor.next;
            }
            cursor.next = newNode;
        }
    }

    public void insertToHead(int val){
        ListNode newNode = new ListNode(val,head);
        head = newNode;
    }

    public void insertToHead(ListNode newNode){
        newNode.next = head;
        head = newNode;
    }

    public void insertBefore(ListNode p, int value) {
        ListNode newNode = new ListNode(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(ListNode p, ListNode newNode) {
        if (p == null) return;
        if (head == p) {
            insertToHead(newNode);
            return;
        }

        ListNode q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        newNode.next = p;
        q.next = newNode;

    }

    public void deleteByNode(ListNode p) {
        if (p == null || head == null) return;

        if (p == head) {
            head = head.next;
            return;
        }

        ListNode q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        q.next = q.next.next;
    }

    public void deleteByValue(int value) {
        if (head == null) return;

        ListNode p = head;
        ListNode q = null;
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }

        if (p == null) return;

        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }

        // 可重复删除指定value的代码
        /*
           if (head != null && head.data == value) {
                head = head.next;
           }
           ListNode pNode = head;
           while (pNode != null) {
           if (pNode.next.data == data) {
           pNode.next = pNode.next.next;
                continue;
           }
           pNode = pNode.next;
           }
         */
    }



    public static class ListNode{
        private int val;
        private ListNode next;

        public ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }

        public int getVal(){
            return this.val;
        }
    }



}
