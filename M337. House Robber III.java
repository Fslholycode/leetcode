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
    public int rob(TreeNode root) {
        int[] res = robsub(root);
        return Math.max(res[0], res[1]);
    }
    public int[] robsub(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = robsub(root.left);
        int[] right = robsub(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0],left[1])+Math.max(right[0], right[1]);
        res[1] = root.val+left[0]+right[0];
        return res;
    }
}