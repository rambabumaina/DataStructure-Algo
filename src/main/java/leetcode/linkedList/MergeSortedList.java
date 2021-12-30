package leetcode.linkedList;

public class MergeSortedList {
    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(5);
        l1.next.next.next = new Node(6);
        
        Node l2 = new Node(3);
        l2.next = new Node(4);
        l2.next.next = new Node(5);
        
        Node result =mergeList(l1,l2);

        while (result !=null){
            System.out.print(result.data + " ");
            result = result.next;
        }
        
    }

    private static Node mergeList(Node l1, Node l2) {

        if (l1 == null) {
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        Node temp = new Node(Integer.MIN_VALUE);
        Node prev = temp;
        while (l1 !=null && l2 !=null ){

            if(l1.data < l2.data){
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null?l2:l1;
        return temp.next;
    }
}
