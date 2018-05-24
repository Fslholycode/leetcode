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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while (!q.isEmpty()) {
            d--;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                TreeNode left = cur.left;
                TreeNode right = cur.right;
                if (d == 1) {
                    cur.left = new TreeNode(v);
                    cur.right = new TreeNode(v);
                    cur.left.left = left;
                    cur.right.right = right;
                } else {
                    if (left != null) q.offer(left);
                    if (right != null) q.offer(right);
                }
            }
            if (d==1) return root;
        }
        return root;
    }
}