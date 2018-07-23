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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root == null) return res;
        Stack<TreeNode> s = new Stack();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            res.add(0, node.val);
            if (node.left != null) s.push(node.left);
            if (node.right != null) s.push(node.right);
        }
        return res;
    }
}