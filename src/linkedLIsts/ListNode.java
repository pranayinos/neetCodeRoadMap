package linkedLIsts;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createListFromArray(int[] input) {
        if (input.length == 0) {
            return null;
        }
        ListNode head = new ListNode();
        head.val = input[0];
        ListNode c = head;
        for (int i = 1; i < input.length; i++) {
            ListNode ln = new ListNode();
            ln.val = input[i];
            c.next = ln;
            c = ln;
        }
        return head;
    }
}