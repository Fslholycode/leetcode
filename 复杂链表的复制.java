/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null) return null;
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode clone = new RandomListNode(node.label);
            clone.next = node.next;
            node.next = clone;
            node = node.next.next;
        }
        node = pHead;
        while (node != null) {
            if (node.random != null) node.next.random = node.random.next;
            node = node.next.next;
        }
        node = pHead;
        RandomListNode res = node.next;
        while (node.next != null) {
            RandomListNode listnode = node.next;
            node.next = node.next.next;
            node = listnode;
        }
        return res;
    }
}