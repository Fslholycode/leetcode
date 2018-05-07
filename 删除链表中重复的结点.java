/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode res = new ListNode(0);
        ListNode pre = res;
        while (pHead != null && pHead.next != null) {
            if (pHead.val == pHead.next.val) {
                while (pHead != null && pHead.next != null && pHead.val == pHead.next.val) pHead = pHead.next;
                if (pHead.next != null) pHead = pHead.next;
                else return res.next;
            } else {
                pre.next = new ListNode(pHead.val);
                pHead = pHead.next;
                pre = pre.next;
            }
        }
        pre.next = pHead;
        return res.next;
    }
}