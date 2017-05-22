/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        ListNode newhead = new ListNode(head.val);
        while (node.next != null) {
            node = node.next;
            ListNode newNode = new ListNode(node.val);
            newNode.next = newhead;
            newhead = newNode;
        }
        return newhead;
    }
}