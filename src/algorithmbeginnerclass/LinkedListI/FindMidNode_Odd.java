package algorithmbeginnerclass.LinkedListI;

import utility.ListNode;

public class FindMidNode_Odd {

    ListNode findMiddleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
