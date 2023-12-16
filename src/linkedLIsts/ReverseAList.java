package linkedLIsts;

public class ReverseAList {
    public static void main(String[] args) {
        ListNode head = ListNode.createListFromArray(new int[] { 1, 2, 356, 32, 4, 5, 6, 7, 8, 9, 10 });
        Solution sol = new Solution();
        ListNode headR = sol.reverseList(head);
        // while (head!=null) {
        // System.out.println(head.val);
        // head = head.next;
        // }
        while (headR != null) {
            System.out.println(headR.val);
            headR = headR.next;
        }
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode p = null;
            ListNode c = head;
            while (head != null) {
                head = head.next;
                c.next = p;
                p = c;
                c = head;
            }
            return p;
        }
    }

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */