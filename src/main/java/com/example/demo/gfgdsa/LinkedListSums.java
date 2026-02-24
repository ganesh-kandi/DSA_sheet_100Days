package com.example.demo.gfgdsa;

public class LinkedListSums {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,5};
        /*Node head = convertArrayToLL(arr);
        printNode(head);
        Node node = new Node(arr[1]);
        //deleteNode(head,node);
        printNode(head);

        Node headNode = insertNodeAtHead(head, new Node(199));
        printNode(headNode);

        Node tailNode = insertNodeAtTail(headNode, new Node(199));
        printNode(tailNode);

        Node afterNode = insertNodeAfterGivenNode(headNode, node,188);
        printNode(afterNode);

        insertNodeAtPosition(headNode, 3,200);*/
        DoubleNode dHead = convertArrayToDLL(arr);
        printDLL(dHead);
        DoubleNode rHead = revereDLL(dHead);
        printDLL(rHead);
    }

    private static DoubleNode revereDLL(DoubleNode dHead) {
        DoubleNode temp = dHead;
        DoubleNode last = null;
        while(temp!= null){
            last = temp.back;
            temp.back= temp.next;
            temp.next= last;

            temp= temp.back;
        }

        return last.back;
    }

    private static void printDLL(DoubleNode dHead) {
        DoubleNode temp = dHead;
        while(dHead!=null){
            System.out.print(dHead.val+ " ");
            dHead= dHead.next;
        }
        System.out.println();
    }

    private static DoubleNode convertArrayToDLL(int[] arr) {
         DoubleNode head = new DoubleNode(arr[0]);
         DoubleNode node = head;
         for(int i=1; i<arr.length;i++){
             DoubleNode temp = new DoubleNode(arr[i]);
             node.next=temp;
             temp.back= node;
             node = temp;
         }
         return head;
    }

    private static Node insertNodeAtPosition(Node head, int i, int i1) {
        Node temp = head;


        return temp;
    }

    private static Node insertNodeAfterGivenNode(Node head, Node node, int val) {
        Node temp = head;
        while(temp.next!=null){
            if(temp.val==node.val){
                Node newNode = new Node(val);
                newNode.next= temp.next;
                temp.next= newNode;
                break;
            }
            temp=temp.next;
        }
        return head;
    }

    private static Node insertNodeAtTail(Node head, Node node) {
        Node temp= head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next=node;
        return head;
    }

    private static Node insertNodeAtHead(Node head, Node node) {
        node.next=head;
        return node;
    }

    private static Node deleteNode(Node head, Node node) {
        Node temp = head;
        Node prev = null;
        while(temp!=null){
            if(temp.val==node.val){
                prev.next= temp.next;
                temp.next=null;
                break;
            }
            prev = temp;
            temp= temp.next;
        }

        return head;
    }

    private static void printNode(Node node) {
        Node temp= node;
        while(temp!=null){
            System.out.print(temp.val + " ");
            temp= temp.next;
        }
        System.out.println();
    }

    private static Node convertArrayToLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp1=head;
        for(int i=1; i<arr.length;i++){
            Node temp= new Node(arr[i]);
            temp1.next= temp;
            temp1 = temp;
        }
        return head;
    }




}
class Node{
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

class DoubleNode{
    int val;
    DoubleNode next;
    DoubleNode back;


    public DoubleNode(int val) {
        this.val = val;
    }
}


