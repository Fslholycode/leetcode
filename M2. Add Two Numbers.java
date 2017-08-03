/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int pre = 0;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (l1 != null && l2 != null) {
            int sum = l1.val+l2.val+pre;
            if (sum >= 10) {
                pre = 1;
                sum -= 10;
            } else {
                pre = 0;
            }
            node.next = new ListNode(sum);
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            int sum = l1.val+pre;
            if (sum >= 10) {
                pre = 1;
                sum -= 10;
            } else {
                pre = 0;
            }
            node.next = new ListNode(sum);
            node = node.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val+pre;
            if (sum >= 10) {
                pre = 1;
                sum -= 10;
            } else {
                pre = 0;
            }
            node.next = new ListNode(sum);
            node = node.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 == null && pre == 1) {
            node.next = new ListNode(1);
        }
        return dummy.next;
    }
}