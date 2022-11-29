package algorithmbeginnerclass.LinkedListI;

import utility.ListNode;

public class FindMidNode_Even_SecondOneInTheMid {

    public ListNode findMiddleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
