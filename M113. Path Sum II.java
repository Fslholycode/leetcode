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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, sum, 0, res, new ArrayList<>());
        return res;
    }
    public void helper(TreeNode node, int sum, int nowSum, List<List<Integer>> res, ArrayList<Integer> list) {
        list.add(node.val);
        nowSum += node.val;
        if (node.left == null && node.right == null) {
            if (nowSum == sum) res.add(new ArrayList<>(list));
        } else {
            if (node.left != null) helper(node.left, sum, nowSum, res, list);
            if (node.right != null) helper(node.right, sum, nowSum, res, list);
        }
        list.remove(list.size()-1);
    }
}