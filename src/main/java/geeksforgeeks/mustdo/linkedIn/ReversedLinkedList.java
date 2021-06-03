package geeksforgeeks.mustdo.linkedIn;

//https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1#
public class ReversedLinkedList {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);

//        Node result = reverseList(node);
//        while (result != null) {
//            System.out.print(" =>"+result.data);
//            result = result.next;
//        }

        Node previous =null;
        Node result = reverseListUsingRecursion(node, previous);
        while (result != null) {
            System.out.print(" =>" + result.data);
            result = result.next;
        }

    }


    private static Node reverseListUsingRecursion(Node head, Node previous) {

            if(head == null){
                return previous;
            }

            Node next = head.next;
            head.next = previous;
            previous = head;

        return reverseListUsingRecursion(next, previous);
    }


    static Node reverseList(Node head) {
        Node current = head;
        Node previous = null, next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }


}
