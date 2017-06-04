/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode fakeshead = new ListNode(0), fakebhead = new ListNode(0), snode = fakeshead, bnode = fakebhead, node = head;
        while (node != null) {
            ListNode newnode = new ListNode(node.val);
            if (node.val < x) {
                snode.next = newnode;
                snode = newnode;
            } else {
                bnode.next = newnode;
                bnode = newnode;
            }
            node = node.next;
        }
        snode.next = fakebhead.next;
        return fakeshead.next;
    }
}