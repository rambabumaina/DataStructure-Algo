package leetcode.linkedList;

//Approach 1: store list in stack first and traverse again and compare => O(n)+O(n)
//Approach 2: reverse list and compare in second traversal
//Approach 3 : Recussion : first go to the end of the linked list and compare while returning back
public class PalindromeLinkedList {

   static ListNode first = null;

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }

    static boolean isPalindrome(ListNode head) {
        first = head;
        return isPalindromeUtil(head);
    }

    private static boolean isPalindromeUtil(ListNode last) {

        if(last == null){
            return true;
        }

        boolean isPal = isPalindromeUtil(last.next);
        if(!isPal){
            return false;
        }

        isPal = first.val  == last.val;
        first = first.next;

        return isPal;
    }
}
