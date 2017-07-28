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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res, "");
        return res;
    }
    public void helper(TreeNode node, List<String> res, String s) {
        if (node.left == null && node.right == null) {res.add(buildS(s,node)); return;}
        if (node.left != null) helper(node.left, res, buildS(s,node));
        if (node.right != null) helper(node.right, res, buildS(s,node));
    }
    public String buildS(String s, TreeNode node) {
        if (s.length() == 0) s+=node.val;
        else s+="->" + node.val;
        return s;
    }    
    
}