package algorithmclass.linkedlist;

import utility.*;

public class AddTwoNumbers_223 {

    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int val = 0;
        while (a != null || b != null || val != 0) {
            if (a != null) {
                val += a.value;
                a = a.next;
            }
            if (b != null) {
                val += b.value;
                b = b.next;
            }
            cur.next = new ListNode(val % 10);
            val = val / 10;
            cur = cur.next;
        }
        return dummy.next;
    }
}
