package leetcode.linkedList;

class MergeSortedListRecursion {

    public static void main(String[] args) {
        ListNode list1 =  new ListNode(1);
        list1.next =  new ListNode(2);
        list1.next.next =  new ListNode(4);


        ListNode list2 =  new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode result = sortList(list1, list2);

        while(result !=null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    private static ListNode sortList(ListNode list1, ListNode list2) {

        if(list1 == null) return list2;
        if (list2 ==null) return list1;

        if (list1.val < list2.val){
            list1.next = sortList(list1.next, list2);
            return list1;
        }else{
            list2.next = sortList(list1, list2.next);
            return list2;
        }

    }
}
