package algorithmbeginnerclass.debugIV;

import utility.ListNode;

public class ReverseLinkedList {

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
