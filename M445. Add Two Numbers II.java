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
        ListNode l = l1;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        while (l != null) {
            s1.push(l.val);
            l = l.next;
        }
        l = l2;
        while (l != null) {
            s2.push(l.val);
            l = l.next;
        }
        int count = 0;
        while (!s1.empty() || !s2.empty()) {
            int m,n;
            if (s1.empty()) {
                m = 0;
                n = s2.pop();
            } else if (s2.empty()) {
                n = 0;
                m = s1.pop();
            } else {
                m = s1.pop();
                n = s2.pop();
            }
            if (m+n+count >= 10) {
                s3.push(n+m+count-10);
                count = 1;
            } else {
                s3.push(n+m+count);
                count = 0;
            }
        }
        if (count == 1) s3.push(1);
        ListNode head = new ListNode(s3.pop());
        l = head;
        while (!s3.empty()) {
            l.next = new ListNode(s3.pop());
            l = l.next;
        }
        return head;
    }
}