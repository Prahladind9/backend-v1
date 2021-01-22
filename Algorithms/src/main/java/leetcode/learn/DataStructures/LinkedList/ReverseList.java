package leetcode.learn.DataStructures.LinkedList;

public class ReverseList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}



