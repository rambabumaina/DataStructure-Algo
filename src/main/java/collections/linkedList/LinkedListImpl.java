package collections.linkedList;

public class LinkedListImpl {

    Node head;

    LinkedListImpl() {
        head = null;
    }

    public void add(Integer e) {
        Node newNode = new Node(e);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    public void addFirst(Integer e) {
        Node newNode = new Node(e);

        if (head != null) {
            newNode.next = head;
        }

        head = newNode;
    }

    public void removeFirst() {
        Node current = head;
        head = current.next;
    }

    public void remove(Integer e) {
        Node current = head;
        Node previous = null;

        if (current == null) {
            throw new RuntimeException("Empty list..");
        }

        if (current.data.equals(e)) {
            removeFirst();
            return;
        }

        while (current != null) {
            if (current.data.equals(e)) {
                previous.next = current.next;
                break;
            }
            previous = current;
            current = current.next;
        }
    }

    public void displayAll() {
        Node temp = head;

        while (temp != null) {
            System.out.print("->" + temp.data);
            temp = temp.next;
        }

        System.out.println();
    }

    public void sort() {
        Node current = head;

        while (current != null && current.next != null) {
            if (current.data > current.next.data) {
                Node temp = current.next;
                current.next = temp;
                current = temp;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedListImpl test = new LinkedListImpl();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(6);
        test.add(4);
        test.add(5);

        test.displayAll();

        test.sort();

        test.displayAll();

    }
}
