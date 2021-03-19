package amazon.queue;

public class QueueImplUsingLinkedList {
    Node node = null;
    Node front, rear = null;

    public static void main(String[] args) {
        QueueImplUsingLinkedList q = new QueueImplUsingLinkedList();
        q.add(10);
        q.add(20);
        q.PrintQueue();

    }

    void PrintQueue() {
        Node temp = node;
        while (temp != null) {
            System.out.println("->" + temp.data);
            temp = temp.next;
        }
    }


    public void add(int data) {
        Node temp = new Node(data);
        temp = node;

        if (front == null && rear == null) {
            front = node;
            rear = node;
        } else {
            node.next = rear;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
