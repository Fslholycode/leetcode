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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<Integer>();
        if (root == null) return res;
        else {
            l.add(root.val);
            res.add(l);
        }
        int level = 0;
        while (queue.peek() != null) {
            level++;
            Queue<TreeNode> newq = new LinkedList<TreeNode>();
            List<Integer> list = new ArrayList<Integer>();
            while (queue.peek() != null) {
                TreeNode node = queue.poll();
                if (level%2 == 1) {
                    if (node.left != null) {
                        list.add(0, node.left.val);
                        newq.add(node.left);
                    }
                    if (node.right != null) {
                        list.add(0, node.right.val);
                        newq.add(node.right);
                    }
                } else {
                    if (node.left != null) {
                        list.add(node.left.val);
                        newq.add(node.left);
                    }
                    if (node.right != null) {
                        list.add(node.right.val);
                        newq.add(node.right);
                    }
                }
            }
            if (list.size() != 0) res.add(new ArrayList(list));
            queue = newq;
        }
        return res;
    }
}