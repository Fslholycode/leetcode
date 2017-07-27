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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightSideView(root, res, 0);
        return res;
    }
    public void rightSideView(TreeNode root, List<Integer> res, int d) {
        if (root == null) return;
        if (d == res.size()) res.add(root.val);
        rightSideView(root.right, res, d+1);
        rightSideView(root.left, res, d+1);
    }
}