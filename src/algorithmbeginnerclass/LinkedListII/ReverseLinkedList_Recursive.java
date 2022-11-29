package algorithmbeginnerclass.LinkedListII;

import utility.ListNode;

public class ReverseLinkedList_Recursive {

    public ListNode reverseLinkedList(ListNode head) {
        // be careful about the base case,
        // need to make sure the later head.next.next != null.
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
