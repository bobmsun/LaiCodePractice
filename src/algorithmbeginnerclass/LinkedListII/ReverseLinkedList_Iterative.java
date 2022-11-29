package algorithmbeginnerclass.LinkedListII;

import utility.ListNode;

public class ReverseLinkedList_Iterative {

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
