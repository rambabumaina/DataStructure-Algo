package geeksforgeeks.amazon.linkedList;

public class PairwiseSwapElements {
    public static void main(String[] args) {
        PairwiseSwapElements p = new PairwiseSwapElements();
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(8);
        Node r = p.pairwiseSwap(node);
        p.printList(r);
    }

    private void printList(Node node) {
        Node current = node;
        while (current != null) {
            System.out.print("->" + current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    private Node reverseLinkedList(Node node) {
        Node current = node;
        Node next, previous = null;
        while (current != null) {
            next = current.next;
            current.next = previous ;
            previous = current;
            current = next;
        }
        return previous;
    }


    public Node pairwiseSwap(Node head) {
        int n = 2;
        return pairwiseSwap_util(head, n);
    }

    //1->2->3->4->5->6->7->8
    private Node pairwiseSwap_util(Node head, int n) {
        if(head == null){
            return null;
        }

        Node current = head;
        Node next= null;
        Node previous =null;

        int j = 0;
        while (current != null && j < n) {
            next = current.next;
            previous  = current;
            current = next;
            j++;
        }
        previous.next = null;

        Node reversed = reverseLinkedList(head);

        head.next = pairwiseSwap_util(next,n);
        return reversed;
    }
}
