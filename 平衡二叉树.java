public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        int[] d = {0};
        return helper(root, d);
    }
    public boolean helper(TreeNode root, int[] d) {
        if (root == null) {
            d[0] = 0;
            return true;
        }
       int[] left = new int[1];
        int[] right = new int[1];
        if (helper(root.left, left) && helper(root.right, right)) {
            if (Math.abs(left[0]-right[0]) <= 1) {
                d[0] = Math.max(left[0],right[0])+1;
                return true;
            }
        }
        return false;
    }
}