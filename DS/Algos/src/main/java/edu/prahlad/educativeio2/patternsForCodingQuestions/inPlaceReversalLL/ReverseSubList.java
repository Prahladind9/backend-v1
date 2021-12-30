package edu.prahlad.educativeio2.patternsForCodingQuestions.inPlaceReversalLL;

/**
 * Given the head of a LinkedList and two positions ‘p’ and ‘q’,
 * reverse the LinkedList from position ‘p’ to ‘q’.
 *
 * Time: O(n)
 * Space: O(1)
 */
public class ReverseSubList {

    /**
     * 1) Skip the first p-1 nodes, to reach the node at position p.
     * 2) Remember the node at position p-1 to be used later to connect with the reversed sub-list.
     * 3) Next, reverse the nodes from p to q using the same approach discussed in Reverse a LinkedList.
     * 4) Connect the p-1 and q+1 nodes to the reversed sub-list.
     */
    public static ListNode reverse(ListNode head, int p, int q) {
        if(p == q) return head;

        //After skipping 'p-1' nodes, current will point to 'p'th node
        ListNode current = head, previous = null;
        for (int i = 0; current != null & i < p - 1; i++) {
            previous = current;
            current = current.next;
        }

        //We are interested in 3 parts of the LinkedList,
        //  a) part before index 'p',
        //  b) part between index 'p' & 'q'
        //  c) part after index 'q'

        ListNode lastNodeOfFirstPart = previous; //points to 'p-1' node

        //after reversing the LinkedList 'current' will become the last node of the sub-list
        ListNode lastNodeOfSubList = current;
        ListNode next = null;

        for (int i = 0; current != null && i < q-p+1; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        //connect with the first part
        if(lastNodeOfFirstPart != null){
            lastNodeOfFirstPart.next = previous; //'previous' is now the first node of sub-list
        }else {
            //this means p ==1, i.e., we are chaining the first node(head) of the linkedList
            head = previous;
        }

        //connect the last part
        lastNodeOfSubList.next = current;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}