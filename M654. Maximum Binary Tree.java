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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    public TreeNode helper(int[] nums, int start, int end) {
        if (start <0 || end >= nums.length || start > end) return null;
        int index = findmax(nums, start, end);
        TreeNode node = new TreeNode(nums[index]);
        node.left = helper(nums, start, index-1);
        node.right = helper(nums, index+1, end);
        return node;
    }
    public int findmax(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        int res=start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                res = i;
                max = nums[i];
            }
        }
        return res;
    }
}