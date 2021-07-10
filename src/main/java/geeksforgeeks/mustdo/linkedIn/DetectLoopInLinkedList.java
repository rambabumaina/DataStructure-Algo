package geeksforgeeks.mustdo.linkedIn;

//https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
public class DetectLoopInLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
//        head.next.next.next.next.next = head.next.next;

        boolean loop = detectLoop(head);
        System.out.println(loop);
    }

    // if linked list has loop fast and slow pointer will meet
    public static boolean detectLoop(Node head) {
        if (head == null && head.next == null) return false;

        Node fast = head;
        Node slow = fast;

        //Find Common Point
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
