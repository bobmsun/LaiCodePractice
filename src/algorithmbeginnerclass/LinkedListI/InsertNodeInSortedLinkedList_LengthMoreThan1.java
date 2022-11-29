package algorithmbeginnerclass.LinkedListI;

import utility.ListNode;

public class InsertNodeInSortedLinkedList_LengthMoreThan1 {

    public ListNode insertNode(ListNode head, int target) {
        ListNode curr = head;
        while (curr.next != null) {
            if (target >= curr.value && target <= curr.next.value) {
                ListNode newNode = new ListNode(target);
                ListNode temp = curr.next;
                curr.next = newNode;
                newNode.next = temp;
                return head;
            }
            curr = curr.next;
        }
        return head;
    }
}
