package amazon.linkedList;

public class ReorderList {
    public static void main(String[] args) {

        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);
        list.next.next.next.next = new Node(5);
//        list.next.next.next.next.next= new Node(6);

        ReorderList r = new ReorderList();
        Node finalList = r.reorderlist(list);
        r.printList(finalList);
    }

    public Node reorderlist(Node head) {

        Node mid = getMiddleNode(head);
        Node r = reverseList(mid.next);
        mid.next = null;

        return mergeLists(head, r);
    }


    private Node mergeLists(Node list, Node r) {

        Node current = list;
        Node previous = list;
        Node next = null;

        while (current != null && r != null) {
            next = current.next;
            current.next = r;
            r = r.next;
            current = current.next;
            current.next = next;
            current = next;
        }
        return previous;
    }


    private Node reverseList(Node list) {
        Node current = list;
        Node previous = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    private Node getMiddleNode(Node list) {
        Node fast = list;
        Node slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    private static void printList(Node list) {
        Node temp = list;
        while (temp != null) {
            System.out.print(" ->" + temp.data);
            temp = temp.next;
        }
    }
}
