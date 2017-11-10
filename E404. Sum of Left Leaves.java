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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        Stack<TreeNode> s = new Stack<TreeNode>();
        stack.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) res += node.left.val;
                else s.push(node.left);
            }
            if (node.right != null) {
                if (node.right.left != null || node.right.right != null) s.push(node.right);
            }
        }
        return res;
    }
}