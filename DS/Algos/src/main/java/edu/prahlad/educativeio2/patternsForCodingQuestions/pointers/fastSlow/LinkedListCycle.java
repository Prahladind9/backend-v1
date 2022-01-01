package edu.prahlad.educativeio2.patternsForCodingQuestions.pointers.fastSlow;

/**
 * Given the head of a Singly LinkedList,
 * write a function to determine if the LinkedList has a cycle in it or not.
 *
 * Time: O(n)
 * Space: O(1)
 *
 */
public class LinkedListCycle {

    /**
     * 1) If the fast pointer is one step behind the slow pointer
     * 2) If the fast pointer is two steps behind the slow pointer
     */
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
    }

}

