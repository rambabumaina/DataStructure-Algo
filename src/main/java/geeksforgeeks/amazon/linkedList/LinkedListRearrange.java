package geeksforgeeks.amazon.linkedList;

public class LinkedListRearrange {

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(4);
        head.next.next = new Node(9);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next = new Node(4);

        head = rearrange(head);

        printList(head);
    }

    public static Node rearrange(Node head)
    {
        Node aList = head;

        if(head.next != null){
            Node bList = head.next;

            Node anext = aList;
            Node bnext = bList;

            Node current = head.next.next;
            while (current!= null){
                anext.next = current;
                bnext.next = current.next;
                anext = anext.next;
                bnext = bnext.next;

                if(current.next != null){
                    current = current.next.next;
                }
                else break;

            }

            anext.next =null;

            bList = reverseList(bList);
            anext.next = bList;
        }
         return aList;
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
