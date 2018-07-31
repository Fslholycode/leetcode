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
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }
    
    public int[] helper(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[1],left[0])+Math.max(right[1], right[0]);
        res[1] = root.val+left[0]+right[0];
        return res;
    }
}