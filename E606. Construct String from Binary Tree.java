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
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        return Helper(t,sb);
    }
    public String Helper(TreeNode t, StringBuilder sb) {
        if (t == null) return "";
        sb.append(Integer.toString(t.val));
        if (t.left == null && t.right == null) sb.append("");
        else {
            if (t.left == null) {
                sb.append("()");
            } else {
                sb.append("(");
                Helper(t.left, sb);
                sb.append(")");
            }
            if (t.right != null) {
                sb.append("(");
                Helper(t.right,sb);
                sb.append(")");
            }
        }
        return sb.toString();
    }
}