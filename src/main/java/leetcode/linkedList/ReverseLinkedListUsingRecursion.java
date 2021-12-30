package leetcode.linkedList;

import org.w3c.dom.NodeList;

public class ReverseLinkedListUsingRecursion {
    static ListNode r;

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode resultNode = null;
        printList(head);
        reverseList(head);
        System.out.println();
        printList(r);
    }

    static void printList(ListNode h) {
        if (h == null) {
            return;
        }
        System.out.print(h.val + " ");
        printList(h.next);
    }

    static ListNode reverseList(ListNode p){
        reverseListUtil(p);
        return r;
    }


    static void reverseListUtil(ListNode p) {
        if(p.next == null){
            r = p;
            return;
        }

        reverseListUtil(p.next);
        ListNode newNode = p.next;
        newNode.next = p;
        p.next = null;
    }

}
