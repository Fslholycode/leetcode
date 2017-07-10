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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] dp = new List[n+1];
        dp[0] = new ArrayList<TreeNode>();
        if (n == 0) return dp[0];
        dp[0].add(null);
        dp[1] = new ArrayList<TreeNode>();
        dp[1].add(new TreeNode(1));
        for (int level = 2; level <= n; level++) {
            dp[level] = new ArrayList<TreeNode>();
            for (int root = 0; root < level; root++) {
                for (TreeNode nodeR : dp[level-root-1]) {
                    for (TreeNode nodeL : dp[root]) {
                        TreeNode node = new TreeNode(root+1);
                        node.left = nodeL;
                        node.right = clone(nodeR, root+1);
                        dp[level].add(node);
                    }
                }
            }
        }
        return dp[n];
    }
    public TreeNode clone(TreeNode n, int set) {
        if (n == null) return n;
        TreeNode node = new TreeNode(n.val+set);
        node.left = clone(n.left, set);
        node.right = clone(n.right, set);
        return node;
    }
}