package geeksforgeeks.amazon.linkedList;

public class AddTwoLinkedList {
    public static void main(String[] args) {
        //4->5
        Node list1 = new Node(4);
        list1.next = new Node(5);

        //3->4->5
        Node list2 = new Node(3);
        list2.next = new Node(4);
        list2.next.next = new Node(5);
//        addList(list1, list2);


    }

    private static Node addTwoLists(Node list1, Node list2) {

        list1 = reverseList(list1);
        list2 = reverseList(list2);
        Node result = null;
        int carry = 0;
        Node ptr = null;

        while (list1 != null || list2 != null) {
            int num = carry + (list1 != null ? list1.data : 0) + (list2 != null ? list2.data : 0);
            carry = num >= 10 ? 1 : 0;

            if (result == null) {
                result = new Node(num % 10);
                ptr = result;
            } else {
                ptr.next = new Node(num % 10);
                ptr = ptr.next;
            }

            if (list1 != null)
                list1 = list1.next;

            if (list2 != null)
                list2 = list2.next;
        }

        if(carry ==1){
            ptr.next = new Node(carry);
        }

        result = reverseList(result);
        return result;

    }

    private static Node reverseList(Node list) {

        Node previous = null;
        Node current = list;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

}
