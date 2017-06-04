/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
       ListNode cur = head, next = null, fake = new ListNode(0);
       while (cur != null) {
           next = cur.next;
           ListNode now = fake;
           while (now.next != null && now.next.val < cur.val) {
               now = now.next;
           }
           cur.next = now.next;
           now.next = cur;
           cur = next;
           
       }
       return fake.next;
    }
}