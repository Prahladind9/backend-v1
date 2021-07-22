package edu.prahlad.zeroToMastery.linkedList;

/**
 * Given a linked list, return it in reverse
 */
public class ReverseLL {

    /**
     * 0) Visualize the problem
     *
     * 1) Verify the constraints
     *      What do we return if we get null or single node?
     *      Just return null and the node back respectively/
     *
     * 2) Write out some test cases
     *      a) 1 > 2 > 3 > 4 > 5 > null; soln: 5 > 4 > 3 > 2 > 1 > null
     *      b) 3    ; soln: 3
     *      b) null ; soln: null
     *
     * 3) Figure out a solution without code
     * 4) Write out our solution in code
     * 5) Double check for errors, syntax or code
     * 6) Check with test cases
     * 7) Analysis (already optimized)
     *
     *      Technique: Iteration
     *      TimeComplexity: O(n), where n size of the linked list
     *      SpaceComplexity: O(1)
     *
     */

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            //reference
            var next = current.next;

            //updating the prev - used as final result
            current.next = prev;
            prev = current;

            //reset
            current = next;
        }

        return prev;

    }

    // prints content of double linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }


    // Driver Code
    public static void main(String[] args) {

        //Test case 1
        ReverseLL list = new ReverseLL();
        list.head = new Node(5);
        list.head.next = new Node(4);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(2);
        list.head.next.next.next.next = new Node(1);

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverseLinkedList(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
        System.out.println();

        //Test case 2
        list = new ReverseLL();
        list.head = new Node(3);
        head = list.reverseLinkedList(head);
        System.out.println("Reversed linked list ");
        list.printList(head);
        System.out.println();

        //Test case 3
        list = new ReverseLL();
        list.head = null;
        head = list.reverseLinkedList(head);
        System.out.println("Reversed linked list ");
        list.printList(head);
    }
}
