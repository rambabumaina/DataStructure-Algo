package leetcode.linkedList;

//Input :=> a->b->c->d->e-null
//Output :=>a->e->d->b->c=null

public class FoldLInkedList {
    public static void main(String[] args) {
        Node l1 = new Node('a');
        l1.next = new Node('b');
        l1.next.next = new Node('c');
        l1.next.next.next = new Node('d');
        l1.next.next.next.next = new Node('e');
        l1.next.next.next.next.next = new Node('f');

        printList(l1);
        fold(l1);
    }

    private static void fold(Node head) {
        //find middle
        Node fast = head, slow = fast, current =null;

        while (fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        current = slow.next;
        slow.next = null;


        current = reverseList(current);

        fast =head;
        Node l1= head;
        Node l2= current;
        boolean flag = true;

        while (l1 !=null && l2 !=null){
            if(flag){
                head = head.next;
                l1.next =l2;
                l1 = head;
                flag = false;
            }else{
                current = current.next;
                l2.next =l1;
                l2 = current;
                flag = true;
            }
        }

        head =fast;
        printList(head);

    }

    private static void printList(Node head) {
        while (head != null){
            System.out.print("->"+ head.data );
            head = head.next;
        }
        System.out.println();
    }

    private static Node reverseList(Node head) {
        Node current = head, prev=null, Next=null;

        while (current !=null){
            Next = current.next;
            current.next = prev;
            prev = current;
            current = Next;
        }

        return prev;
    }

    static class Node{
        char data;
        Node next;

        Node(char data){
           this.data = data;
        }
    }
}
