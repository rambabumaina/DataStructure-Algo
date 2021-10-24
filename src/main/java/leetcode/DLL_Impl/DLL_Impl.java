package leetcode.DLL_Impl;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class DLL_Impl {

    private class Node {
        int data;
        Node next;
        Node perv;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head = null;
    Node tail = null;
    int size;

    DLL_Impl() {
        this.size=0;
        this.head = null;
        this.tail = null;

    }

    public static void main(String[] args) {
        DLL_Impl impl = new DLL_Impl();
        impl.AddLastNode(10);
        impl.AddLastNode(20);
        impl.AddLastNode(30);
        impl.AddLastNode(40);
        impl.AddLastNode(50);

//        impl.addFirstNode(10);
//        impl.addFirstNode(20);
//        impl.addFirstNode(30);
//        impl.addFirstNode(40);
//        impl.addFirstNode(50);

        impl.print();

        System.out.println("Size :" + impl.size());

        impl.removeFirstNode();
        impl.print();

        System.out.println("Size :" + impl.size());

        impl.removeLastNode();
        impl.print();

        System.out.println("Size :" + impl.size());

    }

    private int size() {
        return size;
    }

    public void print() {
        Node current = head;
        System.out.println("Head to tail traversal...");
        while (current != null) {
            System.out.print("->" + current.data);
            current = current.next;
        }
        System.out.println();

        Node current1 = tail;
        System.out.println("Tail to Head traversal...");
        while (current1 != null) {
            System.out.print("->" + current1.data);
            current1 = current1.perv;
        }
        System.out.println();
    }

    //Node at beginning of the DLL
    //Only play with head
    public void addFirstNode(int data) {
        //create new Node
        Node newNode = new Node(data);

        // If Empty list then assign new node to tail or else assign it to head.perv
        if (head == null && tail == null) {
            tail = newNode;
        } else {
            head.perv = newNode;
        }

        // join link b/w new node to existing list
        newNode.next = head;
        //make new node to head
        head = newNode;
        size++;
    }


    // Add node to the last node
    //only play with tail
    public void AddLastNode(int data) {
        //new node
        Node newNode = new Node(data);

        //if head is null then assign head to newNode or else assign it to tail.next
        if (head == null && tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        //join new node to the existing list using tail
        newNode.perv = tail;
        tail = newNode;
        size++;
    }

    public Node removeFirstNode() {
        if (size() == 0) {
            throw new NoSuchElementException("Empty linked list");
        }

        Node temp = head;

        if (head == tail) {
            tail = null;
        }else{
            head.next.perv = null;
        }
        head = head.next;
        temp.next = null;
        size--;
        return temp;
    }

    public Node removeLastNode() {
        if(size() ==0){
            throw new NoSuchElementException("Empty linked list");
        }

        Node temp = tail;

        if(head == tail){
            head = null;
        }else{
            tail.perv.next = null;
        }

        tail = tail.perv;
        temp.perv = null;

        size--;
        return temp;
    }


}


