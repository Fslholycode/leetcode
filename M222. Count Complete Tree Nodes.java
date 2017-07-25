/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        if (lh == rh) return (1<<lh)+countNodes(root.right);
        else return (1<<rh)+countNodes(root.left);
    }
    public int height(TreeNode node) {
        if (node == null) return 0;
        return 1+height(node.left);
    }
}