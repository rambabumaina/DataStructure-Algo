package leetcode.linkedList;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(4);

        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);
        l2.next.next.next = new Node(6);
        l2.next.next.next.next = new Node(6);

        Node node = mergeTwoLists(l1, l2);
        printList(node);
    }

    private static void printList(Node node) {

        while(node != null){
            System.out.print("->" + node.data + " ");
            node = node.next;
        }
    }

    public static Node mergeTwoLists(Node l1, Node l2) {
        if(l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        Node current = null;
        Node result = null;

        while (l1 != null && l2 != null) {

            if(l1.data < l2.data){
                if(result == null){
                    result = l1;
                    current = result;
                    l1 = l1.next;
                }else{
                   current.next = l1;
                   current = current.next;
                   l1 = l1.next;
                }
            }else{
                if(result == null){
                    result = l2;
                    current = result;
                    l2 = l2.next;
                }else{
                    current.next = l2;
                    current = current.next;
                    l2 = l2.next;
                }
            }
        }

        if(l1 == null){
            current.next = l2;
        }else{
            current.next = l1;
        }
        return result;
    }
}