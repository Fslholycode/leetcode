/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int len = 0;
        ListNode node = root;
        while (node != null) {
            len++;
            node = node.next;
        }
        int n = len/k;
        int m = len%k;
        node = root;
        ListNode prev = null;
        for (int i = 0; node != null && i < k; i++, m--) {
            res[i] = node;
            for (int j = 0; j < n+(m>0?1:0); j++) {
                prev = node;
                node = node.next;
            }
            prev.next = null;
        }
        return res;
    }
}