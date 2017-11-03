/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int res = 0;
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (root.left != null && root.right != null && root.val == root.left.val && root.val == root.right.val) {
            if (left+right+2 > res) 
                res = left+right+2;
            return Math.max(left,right)+1;
        }                      
        if (root.left != null && root.val == root.left.val) {
            left = left+1;
            if (left > res) res = left;
            return left;
        }
        if (root.right != null && root.val == root.right.val) {
            right = right+1;
            if (right > res) res = right;
            return right;
        }
        return 0;
    }
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return res;
    }
}