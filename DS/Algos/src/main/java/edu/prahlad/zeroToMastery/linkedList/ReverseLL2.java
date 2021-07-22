package edu.prahlad.zeroToMastery.linkedList;

/**
 * Given a linked list and numbers m and n,
 * return it back with only "positions" m to n in reverse
 *
 * Leetcode
 * 92. Reverse Linked List II
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLL2 {
    /**
     * 0) Visualize the problem
     *      Flip the linked list between the given positions
     *
     * 1) Verify the constraints
     *      q) Will m and n always be within the bounds of the linked list?
     *          Yes, assume 1 <= m <= n <= length of linked list
     *
     *      q) Can we receive m and n values for the whole linked list?
     *          Yes, we can receive m = 1 & n = length of linked list
     *
     *  2) Write some test cases
     *      a) 1 > 2 > 3 > 4 > 5 > null, m = 2 and n = 4
     *         1 > 4 > 3 > 2 > 5 > null
     *
     *      b) 1 > 2 > 3 > 4 > 5 > null, m = 1 and n = 5
     *          5 > 4 > 3 > 2 > 1 > null
     *
     *       c) 5 > null, m = 1, n =1
     *          5 > null
     *
     *       d) null, m=0, n=0
     *          null
     *
     *  3) Figure out a solution without code (Critical Thinking)
     *
     *  reverse linked list steps between m & n position
     *      a) get current node
     *      b) store next value
     *      c) update next value to list so far
     *      d) store current node as list so far
     *      e) update current node to stored next value at (b)
     *
     *      position pointer & m-1, m, n, n+1 position linked list value needs to be tracked
     *
     *  4) Writing solution
     *  5) Cross checking for errors
     *  6) Check with test cases
     *  7) Analysis
     *          Technique       : Iterative
     *          Time Complexity : O(n)
     *          Space Complexity: O(1)
     *
     */

    public static Node reverseBetween(Node head, int m, int n){
        int currentPos = 1;
        Node currentNode = head;
        Node startNode = head; //will be used to store (m-1) position

        while (currentPos < m){
            startNode = currentNode;
            currentNode = currentNode.next; //increment
            currentPos++;
        }

        //flipping/reversing the list starts, m to n position
        Node newList = null; //flipped list from m to n will be stored
        Node tail = currentNode;//m position will later become tail

        while (currentPos >= m && currentPos <= n){
            Node next = currentNode.next; //~temp variable
            currentNode.next = newList;
            newList = currentNode;

            currentNode = next;
            currentPos++;
        }

        //Combine all the pieces :)
        startNode.next = newList;
        tail.next = currentNode;

        if(m > 1){
            return head;
        }else {
            return newList;
        }
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
        list.head = reverseBetween(list.head, 2, 4);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(list.head);
        System.out.println();
    }

}
