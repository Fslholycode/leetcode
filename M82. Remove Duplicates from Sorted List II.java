/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (node.next != null && node.next.next != null) {
            if (node.next.val == node.next.next.val) {
                ListNode nextNode = node.next.next;
                while (nextNode.next != null) {
                    if (nextNode.val == nextNode.next.val) nextNode = nextNode.next;
                    else break;
                }
                node.next = nextNode.next;
            } else {
                node = node.next;
            }
        }
        return dummy.next;
    }
}