/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node1 = l1,node2 = l2,head,node;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            head = l1;
            node1 = l1.next;
        } else {
            head = l2;
            node2 = l2.next;
        }
        node = head;
        while (node1 != null || node2 != null) {
            if (node1 == null) {
                node.next = node2;
                return head;
            } else if (node2 == null) {
                node.next = node1;
                return head;
            } else {
                if (node1.val <= node2.val) {
                    node.next = node1;
                    node1 = node1.next;
                    node = node.next;
                } else {
                    node.next = node2;
                    node2 = node2.next;
                    node = node.next;
                }
            }
        }
        
        return head;
    }
}