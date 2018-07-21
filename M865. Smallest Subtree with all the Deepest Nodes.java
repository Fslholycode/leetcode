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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap();
        depth(root, map);
        return dfs(root, map);
    }
    
    public int depth(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) return 0;
        if (map.containsKey(node)) return map.get(node);
        int left = 1+depth(node.left, map);
        int right = 1+depth(node.right, map);
        int d = Math.max(left, right);
        map.put(node, d);
        return d;
    }
    public TreeNode dfs(TreeNode node, Map<TreeNode, Integer> map) {
        Integer left = 0;
        Integer right = 0;
        if (node.left != null) left = map.get(node.left);
        if (node.right != null) right = map.get(node.right);
        if (left == right) return node;
        else if (left < right) return dfs(node.right, map);
        else return dfs(node.left, map);
    }
}