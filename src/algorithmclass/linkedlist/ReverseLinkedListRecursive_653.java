package algorithmclass.linkedlist;

import utility.*;

public class ReverseLinkedListRecursive_653 {

    public ListNode reverseLinkedList(ListNode head) {
        // be careful about the base case,
        // nee to make sure the later head.next.next != null.
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
