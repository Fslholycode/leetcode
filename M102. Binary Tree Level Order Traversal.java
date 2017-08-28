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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res =  new ArrayList<>();
        helper(res, 0, root);
        return res;
    }
    public void helper(List<List<Integer>> res, int depth, TreeNode node) {
        if (node == null) return;
        if (res.size() <= depth) res.add(new ArrayList<>());
        res.get(depth).add(node.val);
        helper(res, depth+1, node.left);
        helper(res,depth+1, node.right);
    }
}