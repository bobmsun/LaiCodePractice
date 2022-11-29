package utility;

public class ListNode {

    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;     // this line is not necessary
    }

    public static ListNode buildListFromArray(int[] array) {
        // Assume array is NOT null
        // If array has length zero, then return null.

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        for (int value : array) {
            pre.next = new ListNode(value);
            pre = pre.next;
        }
        return dummy.next;
    }

    // Print linked list
    public static void printLinkedList(ListNode head) {
        // If head is null, then print "null"

        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

}
