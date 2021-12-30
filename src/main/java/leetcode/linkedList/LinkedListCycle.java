package leetcode.linkedList;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/773/
public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;

        System.out.println(hasCycle(head));
    }

    static boolean hasCycle(ListNode head) {

        if(head == null || head.next ==null){
            return false;
        }

        ListNode fast =head, slow = fast;

        while (fast !=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }

        return false;
    }
}
