/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        head = sortList(head);
        slow = sortList(slow);
        return merge(head,slow);
    }
    public ListNode merge(ListNode slow, ListNode fast) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (slow != null && fast != null) {
            if (slow.val < fast.val) {
                node.next = slow;
                slow = slow.next;
            } else {
                node.next = fast;
                fast = fast.next;
            }
            node = node.next;
        }
        while (slow != null) {
            node.next = slow;
            slow = slow.next;
            node = node.next;
        }
        while (fast != null) {
            node.next = fast;
            fast = fast.next;
            node = node.next;
        }
        return dummy.next;
    }
}