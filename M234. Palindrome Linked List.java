/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        ListNode node = head;
        while (slow != null && node != null) {
            if (slow.val != node.val) return false;
            slow = slow.next;
            node = node.next;
        }
        return true;
    }
    public ListNode reverse(ListNode slow) {
        ListNode node = slow, newhead = new ListNode(slow.val);
        while (node.next != null) {
            node = node.next;
            ListNode newnode = new ListNode(node.val);
            newnode.next = newhead;
            newhead = newnode;
        }
        return newhead;
    }
}