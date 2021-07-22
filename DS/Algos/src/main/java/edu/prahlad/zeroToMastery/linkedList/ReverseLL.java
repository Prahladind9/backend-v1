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
     *
     *  reverse linked list steps
     *      a) get current node
     *      b) store next value
     *      c) update current's next value to prev
     *      d) assign current to prev
     *      e) update current node to stored next value at (b)
     *
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

    public static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            var next = current.next; //~temp variable

            //updating the prev - used as final result
            current.next = prev;
            prev = current;

            //reset
            current = next;
        }

        return prev;

    }



    // Driver Code
    public static void main(String[] args) {

        //Test case 1
        LinkedList list = new LinkedList();
        list.head = new Node(5);
        list.head.next = new Node(4);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(2);
        list.head.next.next.next.next = new Node(1);

        System.out.println("Given Linked list");
        list.printList(list.head);
        list.head = reverseLinkedList(list.head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(list.head);
        System.out.println();

        //Test case 2
        list = new LinkedList();
        list.head = new Node(3);
        list.head = reverseLinkedList(list.head);
        System.out.println("Reversed linked list ");
        list.printList(list.head);
        System.out.println();

        //Test case 3
        list = new LinkedList();
        list.head = null;
        list.head = reverseLinkedList(list.head);
        System.out.println("Reversed linked list ");
        list.printList(list.head);
    }
}
