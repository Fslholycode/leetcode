/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
         if (pHead1 == null || pHead2 == null) return null;
         if (pHead1 == pHead2) return pHead1;
         ListNode left = FindFirstCommonNode(pHead1, pHead2.next);
         ListNode right = FindFirstCommonNode(pHead1.next, pHead2);
        if (left == null && right == null) return null;
        if (left == null) return right;
        if (right == null) return left;
         if (left == right || left.next == right) return left;
         if (right.next == left) return right; 
        return null;
    }
}