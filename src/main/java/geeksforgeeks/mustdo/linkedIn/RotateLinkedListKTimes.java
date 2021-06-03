package geeksforgeeks.mustdo.linkedIn;

//https://practice.geeksforgeeks.org/problems/rotate-a-linked-list/1
public class RotateLinkedListKTimes {
    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
//        head.next.next = new Node(30);
//        head.next.next.next = new Node(40);
//        head.next.next.next.next = new Node(50);
//        head.next.next.next.next.next = new Node(60);

        Node rotate = rotate(head, 3);

        printList(rotate);

    }

    private static void printList(Node rotate) {
        Node h = rotate;
        while(h != null){
            System.out.print( h.data +"=>");
            h = h.next;
        }
    }

    public static Node rotate(Node head, int k) {
        Node previous = null;
        Node current = head;

        int count = 1;
        previous = current;

        while (current != null) {
            if (count == k) {
                break;
            }
            current = current.next;
            previous = current;
            count++;
        }

        while (current.next !=null){
            current = current.next;
        }

        current.next = head;
        head = previous.next;
        previous.next = null;

        return head;
    }
}
