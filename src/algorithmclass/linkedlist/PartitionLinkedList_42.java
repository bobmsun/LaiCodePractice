package algorithmclass.linkedlist;

import utility.*;

public class PartitionLinkedList_42 {

    public ListNode partition(ListNode head, int target) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode curSmall = small;
        ListNode curLarge = large;
        while (head != null) {
            if (head.value < target) {
                curSmall.next = head;
                curSmall = curSmall.next;
            } else {
                curLarge.next = head;
                curLarge = curLarge.next;
            }
            head = head.next;
        }
        // connect the two partitions
        curSmall.next = large.next;
        // un-link the last node in large partition
        curLarge.next = null;
        return small.next;
    }
}
