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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        HashMap<String, Integer> map = new HashMap<>();
        helper(root, map, res);
        return res;
    }
    public String helper(TreeNode root, HashMap<String, Integer> map, List<TreeNode> res) {
        if (root == null) return "#";
        String tree = root.val+","+helper(root.left, map, res)+","+helper(root.right,map, res);
        if (map.getOrDefault(tree, 0) == 1) res.add(root);
        map.put(tree, map.getOrDefault(tree, 0)+1);
        return tree;
    }
}