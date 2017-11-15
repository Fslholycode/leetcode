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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode cur= null;
        TreeNode left=null;
        TreeNode right=null
            ;
        int sum = 0;
        if (t1 == null && t2 == null) return null;
        if (t1 != null && t2 == null) {
            cur = new TreeNode(t1.val);
            left = mergeTrees(t1.left, null);
            right = mergeTrees(t1.right, null);
        } 
        if (t1 == null && t2 != null) {
            cur = new TreeNode(t2.val);
            left = mergeTrees(null, t2.left);
            right = mergeTrees(null, t2.right);
        }
        if (t1 != null && t2 != null) {
            cur = new TreeNode(t1.val + t2.val);
            left = mergeTrees(t1.left, t2.left);
            right = mergeTrees(t1.right, t2.right);
        }
        cur.left = left;
        cur.right = right;
        return cur;
    }
}