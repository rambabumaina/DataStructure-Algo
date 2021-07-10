package geeksforgeeks.mustdo.linkedIn;

import java.util.HashSet;
import java.util.Set;

//https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1/
public class IntersectionPoint_Y_Shapped {
    public static void main(String[] args) {

        Node node1 = new Node(3);
        node1.next = new Node(6);
        node1.next.next = new Node(9);
        node1.next.next.next = new Node(15);
        node1.next.next.next.next = new Node(30);

        Node head2 = new Node(10);
        head2.next =  node1.next.next.next;

//        System.out.println(intersectPoint(node1, head2));
        System.out.println(intersectPoint_Count(node1, head2));
    }


    // ON and ON solution
    static int intersectPoint(Node head1, Node head2)
    {
            Set<Integer> visitedNodes = new HashSet<>();
            while(head1 != null){
                visitedNodes.add(head1.data);
                head1 = head1.next;
            }
            while(head2 != null){

               if(visitedNodes.contains(head2.data)) {
                   return head2.data;
               }
                head2 = head2.next;
            }

            return 0;
    }

    // ON ,and O1 solution
    static int intersectPoint_Count(Node head1, Node head2){
        int list1_count = 1, list2_count = 1 ;
        Node node1 = head1, node2 = head2;
        
        //find the count of list 1
        while(node1 !=null){
            list1_count++;
            node1 = node1.next;
        }

        while(node2 !=null){
            list2_count++;
            node2 = node2.next;
        }

        //find count difference
        int diff = Math.abs(list1_count -list2_count);
        int count =1;
        node1 = head1;
        while (node1 !=null){
            if(count++ > diff ){
                break;
            }
            node1 = node1.next;
        }

        node2 = head2;
        while(node1 != node2){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1.data;
    }
}
