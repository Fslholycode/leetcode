/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode headodd = new ListNode(head.val);
        ListNode oddnode = headodd;
        ListNode headeven = new ListNode(head.next.val);
        ListNode evennode = headeven;
        ListNode node = head.next;
        ListNode lastodd = headodd;
        boolean isodd = true;
        while (node.next != null) {
            node = node.next;
            ListNode nodenew = new ListNode(node.val);
            if (isodd == true) {
                oddnode.next = nodenew;
                oddnode = nodenew;
                lastodd = nodenew;
            } else {
                evennode.next = nodenew;
                evennode = nodenew;
            }
            isodd = !isodd;
        }
        lastodd.next = headeven;
        return headodd;
    }
}


//good solution
public class Solution {
public ListNode oddEvenList(ListNode head) {
    if (head != null) {
    
        ListNode odd = head, even = head.next, evenHead = even; 
    
        while (even != null && even.next != null) {
            odd.next = odd.next.next; 
            even.next = even.next.next; 
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead; 
    }
    return head;
}}