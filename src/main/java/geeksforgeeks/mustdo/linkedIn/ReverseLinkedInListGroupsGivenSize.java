package geeksforgeeks.mustdo.linkedIn;

public class ReverseLinkedInListGroupsGivenSize {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);

        int k = 3;
        Node result =reverse(head, k);
        printList(result);
    }

    // 2-approaches one is using stack
    //Second is using Recursion

    //First reverse k nodes and recursively called the same
    public static Node reverse(Node head, int k) {
        Node current = head;
        Node previous = null, next = null;
        int count = 0;

        while (count < k && current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++;
        }

        if(next != null)
        head.next = reverse(next, k);
        return previous;
    }


    public static void printList(Node rev) {
        Node current = rev;

        while (current != null) {
            System.out.print("->" + current.data);
            current = current.next;
        }
        System.out.println();
    }
}