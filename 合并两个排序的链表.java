//递归

public ListNode Merge(ListNode list1,ListNode list2) {
       if(list1 == null){
           return list2;
       }
       if(list2 == null){
           return list1;
       }
       if(list1.val <= list2.val){
           list1.next = Merge(list1.next, list2);
           return list1;
       }else{
           list2.next = Merge(list1, list2.next);
           return list2;
       }       
   }

//非递归
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode node = res;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                res.next = new ListNode(list1.val);
                list1 = list1.next;
                res = res.next;
            }
            else {
                res.next = new ListNode(list2.val);
                list2 = list2.next;
                res = res.next;

            }
        }
        if (list1 != null) {
            while (list1 != null) {
                res.next = new ListNode(list1.val);
                list1 = list1.next;
                res = res.next;
            }
        }
        if (list2 != null) {
            while (list2 != null) {
                res.next = new ListNode(list2.val);
                list2 = list2.next;
                res = res.next;
            }
        }
        return node.next;
    }
}