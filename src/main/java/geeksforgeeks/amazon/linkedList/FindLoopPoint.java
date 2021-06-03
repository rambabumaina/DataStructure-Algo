package geeksforgeeks.amazon.linkedList;

public class FindLoopPoint {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = head.next.next;

        Node loop = doesLoopExists(head);
        Node point = PrintLoopPoint(head, loop);
        System.out.println( "=> " + point.data);

    }

    static Node PrintLoopPoint(Node slow, Node fast){
        while(slow != null){
            if(slow == fast){
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return null;
    }

   static Node doesLoopExists(Node head) {

        Node slow = head;
        Node fast = head;

        while((fast != null && fast.next != null)){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return slow;
            }
        }
        return null;
    }
}
