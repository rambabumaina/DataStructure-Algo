package geeksforgeeks.mustdo.linkedIn;

public class RemoveLoopInLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next.next;

        removeLoop(head);
    }

    public static void removeLoop(Node head) {
        Node fast = head, slow = fast;

        if (head == null || head.next == null) return;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                removeLoop(head, slow);
                break;
            }
        }
    }

    public static void removeLoop(Node slow, Node fast) {
        while (slow.next != fast.next) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = null;
    }


    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("=>" + current.data);
            current = current.next;
        }
    }

}

