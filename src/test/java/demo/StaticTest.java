package demo;

public class StaticTest {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        printList(head);
        System.out.println();
        ReverseList(head);
    }

    public static void Test(Object obj){
        System.out.println(obj);
    }

    private static void printList(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data + " ");

        printList(head.next);
    }

    private static void ReverseList(Node head) {
        if (head == null) {
            return;
        }
        ReverseList(head.next);
        System.out.print(head.data + " ");
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}

