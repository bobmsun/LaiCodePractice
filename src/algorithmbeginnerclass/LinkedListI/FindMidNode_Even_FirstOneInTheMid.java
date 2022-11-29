package algorithmbeginnerclass.LinkedListI;

import utility.ListNode;

public class FindMidNode_Even_FirstOneInTheMid {

    ListNode findMiddleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next.next != null) {
            slow = slow.next;
            fast = fast = fast.next.next;
        }
        return slow;
    }
}
