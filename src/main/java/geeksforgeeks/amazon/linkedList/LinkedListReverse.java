package geeksforgeeks.amazon.linkedList;

public class LinkedListReverse {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        printList(head);
        printList(reverseList(head));

    }

    public static Node reverseList(Node head){

        Node current = head;
        Node next, previous = null;

        while (current != null){

            next = current.next;
            current.next = previous;
            previous = current;
            current = next;

        }

        return previous;
    }

    public static void printList(Node head){
        while (head != null){
            System.out.print("->"+ head.data );
            head = head.next;
        }
        System.out.println();
    }

}
