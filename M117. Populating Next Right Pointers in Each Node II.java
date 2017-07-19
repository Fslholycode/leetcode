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
            TreeLinkNode prev = null;
            TreeLinkNode next = null;
            while (n != null) {
                if (n.left != null) {
                    if (prev == null)
                        next = n.left;
                    else prev.next = n.left;
                    if (n.right != null) {
                        n.left.next = n.right;
                        prev = n.right;
                    } else {
                        prev = n.left;
                    }
                } else if (n.right != null) {
                    if (prev == null)
                        next = n.right;
                    else prev.next = n.right;
                    prev = n.right;
                }
                n=n.next;
            }
            node = next;
        }
    }
}