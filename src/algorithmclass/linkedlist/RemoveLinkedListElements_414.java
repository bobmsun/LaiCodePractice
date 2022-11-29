package algorithmclass.linkedlist;

import utility.ListNode;

public class RemoveLinkedListElements_414 {

    public ListNode removeElementsI(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            if (head.value == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public ListNode removeElementsII(ListNode head, int val) {
        ListNode prev = null;
        ListNode newHead = null;
        while (head != null) {
            if (head.value == val) {
                if (prev != null) {
                    prev.next = head.next;
                }
            } else {
                if (newHead == null) {
                    newHead = head;
                }
                prev =  head;
            }
            head = head.next;
        }
        return newHead;
    }
}
