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
    public int minDepth(TreeNode root) {
        return depth(root);
    }
    public int depth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1+depth(root.right);
        if (root.right == null) return 1+depth(root.left);
        return 1+Math.min(depth(root.right),depth(root.left));
    }
}