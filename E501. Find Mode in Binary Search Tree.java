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
    int max = 0;
    TreeNode pre = null;
    int count = 1;
    public int[] findMode(TreeNode root) {
        List<TreeNode> list = new ArrayList();
        helper(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i).val;
        }
        return res;
    }
    public void helper(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        helper(root.left, list);
        if (pre != null) {
            if (pre.val == root.val) count++;
            else {
                count = 1;
            }
        }
        pre = root;
        if (count > max) {
            max = count;
            list.clear();
            list.add(root);
        }
        else if (count == max) {
            list.add(root);
        }
        helper(root.right, list);
    }
}