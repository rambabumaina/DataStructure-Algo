package geeksforgeeks.amazon.linkedList;

public class AddTwoLinkedListsUsingRecurssion {
    public static void main(String[] args) {
        //3->4->5
        Node list1 = new Node(8);
        list1.next = new Node(4);
        list1.next.next = new Node(5);

        //3->4->5
        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(5);

        Node result = addTwoLists(list1, list2);
        printList(result);
    }

    private static Node addTwoLists(Node list1, Node list2){
        Node list = addTwoLists_util(list1,list2);
        if(list !=null && list.data>=10){
            list.data = list.data%10;
            Node temp = new Node(1);
            temp.next =list;
            list = temp;
        }
        return list;
    }

    private static Node addTwoLists_util(Node list1, Node list2) {
        if(list1 == null ){
            return null;
        }

       Node temp =addTwoLists_util(list1.next, list2.next);
        if(temp ==null){
          return new Node(list1.data+list2.data);
        }else{
            int carry = temp.data >=10?1:0;
            temp.data = temp.data%10;

            Node temp2 = new Node(carry+ list1.data+list2.data);
            temp2.next =temp;
            return temp2;
        }
    }

    private static void printList(Node result) {

        while(result !=null){
            System.out.print("->"+result.data);
            result = result.next;
        }
    }
}
