package geeksforgeeks.mustdo.linkedIn;

//https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1
public class FindMiddleElement {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next= new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);

        getMiddle(node);
    }

   static int getMiddle(Node head)
    {
        Node fast = head;
        Node slow = head;

        while (fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }
}
