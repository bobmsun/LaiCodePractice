package algorithmclass.linkedlist;

import utility.ListNode;

public class CheckIfLinkedListIsPalindrome_306 {

    /*

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middle = findMiddle(head);       // see LaiCode #36 above
        ListNode right = reverseLinkedList(middle.next);        // see LaiCode #34 above
        while (right != null) {
            if (head.value != right.value) {
                return false;
            }
            head = head.next;
            right = right.next;
        }
        return true;
    }

     */
}
