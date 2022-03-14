package binarySearch.com.twopointer;

//Devide Linked list in two part
//reverse second part
//compare both
public class PalindromeLinkedList {
    public static void main(String[] args) {

        LLNode ll = new LLNode(1);
        ll.next = new LLNode(0);
//        ll.next.next = new LLNode(1);

//        ll.next.next = new LLNode(4);

        System.out.println(solve(ll));
    }

    static boolean solve(LLNode head) {

        if (head == null) return true;

        //find mid
        LLNode fast = head, slow = fast;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast !=null)
        slow = slow.next;


        slow = reverseList(slow);
        fast = head;

        while(slow != null){

            if(slow.val != fast.val){
                return false;
            }

            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    private static LLNode reverseList(LLNode head) {
        LLNode current = head, prev=null, Next;

        while(current !=null){
            Next = current.next;
            current.next = prev;
            prev = current;
            current = Next;
        }

        return prev;
    }


    private static class LLNode {
        int val;
        LLNode next;

        LLNode(int val) {
            this.val = val;
        }
    }
}
