/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;https://wx2.qq.com/zh_CN/htmledition/v2/images/spacer.gif
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValue(root, 1, new int[]{0,0});
    }
    public int findBottomLeftValue(TreeNode node, int depth, int[] res) {
        if (res[1] < depth) {
            res[0] = node.val;
            res[1] = depth;
        }
        if (node.left != null) findBottomLeftValue(node.left, depth+1, res);
        if (node.right != null) findBottomLeftValue(node.right, depth+1, res);
        return res[0];
    }
}