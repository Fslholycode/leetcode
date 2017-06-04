/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode prev = null ,node = head;
        while (node != null) {
            if (node.val != val) {
                prev = node;
                node = node.next;
            } else {
                if (prev == null) {
                    head = head.next;
                    node = head;
                }
                else {
                    prev.next = node.next;
                    node = prev.next;
                }
            }
        }
        return head;
    }
}