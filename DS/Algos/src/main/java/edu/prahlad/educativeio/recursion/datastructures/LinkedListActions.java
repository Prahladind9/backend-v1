package edu.prahlad.educativeio.recursion.datastructures;

public class LinkedListActions {
    static class Node{
        int value;
        Node next;
    }
    static Node insertAtHead(Node temp_head, int new_value){
        Node new_Node = new Node();
        new_Node.value = new_value;
        new_Node.next = (temp_head);
        temp_head = new_Node;

        return temp_head;
    }

    public static void printReverse(Node head){
        //base case
        if(head == null){
            return;
        }

        //Recursive case
        else {
            printReverse(head.next);
            System.out.println(head.value + " ");
        }
    }

    public static int sumList(Node head){
        //base case
        if(head == null){
            return 0;
        }
        //recursive case
        else {
            return head.value + sumList(head.next);
        }
    }

    public static boolean search(Node head, int num){
        //base case
        if(head == null){
            return false;
        }

        //Recursive case
        else {
            if (head.value == num){
                return true;
            }else {
                return search(head.next, num);
            }
        }
    }

    public static void main( String args[] ) {
        reverseLLHelper();
        sumLLHelper();
        searchValueHelper();
    }

    private static void searchValueHelper() {
        // Empty Linked List
        Node head = null;

        head = insertAtHead(head, 0);
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 1);
        head = insertAtHead(head, 6);
        head = insertAtHead(head, 4);

        System.out.println("Linked List: ");
        for (Node i = head; i != null; i = i.next) {
            System.out.print(i.value + " ");
        }

        System.out.println(" ");
        int searchFor = 8;
        boolean result = search(head, searchFor);
        System.out.println("Is " + searchFor + " present in the list? : " + result);
    }

    private static void sumLLHelper() {
        // Empty Linked List
        Node head = null;

        // Linked List = 3->1->5->8->2
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 8);
        head = insertAtHead(head, 5);
        head = insertAtHead(head, 1);
        head = insertAtHead(head, 3);

        System.out.println("Linked List: ");
        for (Node i = head; i != null; i = i.next) {
            System.out.print(i.value + " ");
        }

        int sum = sumList(head);

        System.out.println(" ");
        System.out.println("Sum: " + sum);
    }

    private static void reverseLLHelper() {
        // Empty Linked List
        Node head = null;

        // Linked List = 1->2->3->4->5
        head = insertAtHead(head, 5);
        head = insertAtHead(head, 4);
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);

        // Print the original Linked List
        System.out.println("Linked List: ");
        for (Node i = head; i != null; i = i.next) {
            System.out.print(i.value + " ");
        }

        // Print the reversed Linked List
        System.out.println(" ");
        System.out.println("Reversed Linked List: ");
        printReverse(head);
    }
}
