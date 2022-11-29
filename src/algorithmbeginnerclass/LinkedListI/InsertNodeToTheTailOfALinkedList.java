package algorithmbeginnerclass.LinkedListI;

import utility.ListNode;

public class InsertNodeToTheTailOfALinkedList {

    ListNode insertNode(ListNode head, int target) {
        if (head == null) {
            return new ListNode(target);
        }
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new ListNode(target);
        return head;
    }
}
