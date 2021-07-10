package geeksforgeeks.mustdo.linkedIn;

//https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1
public class NthNodeFromEnd {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.println(">>" + getNthFromLast(head, 0));
    }

    //Increment current util reaches variable and break the loop
    // Second loop : previous start from head and current start from nth position
    static int getNthFromLast(Node head, int n) {
        Node previous = head, current = previous;

        int count = 1;
        while (current != null) {
            if (count == n) {
                break;
            }
            current = current.next;
            count++;
        }

        //return -1 if n is greater than size of list
        if(current ==null){
            return -1;
        }

        while (current.next != null){
            current = current.next;
            previous = previous.next;
        }

        return previous.data;
    }
}