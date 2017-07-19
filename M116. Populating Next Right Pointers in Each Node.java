/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode node = root;
        while (node != null) {
            TreeLinkNode n = node;
            while (n!=null) {
                if (n.left != null) n.left.next = n.right;
                if (n.right!= null && n.next!=null) n.right.next = n.next.left;
                n = n.next;
            }
            node = node.left;
        }
    }
}