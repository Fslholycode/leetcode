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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length-1);
    }
    public TreeNode sortedArrayToBST(int[] nums, int l1, int l2) {
        if (l1 > l2) return null;
        int mid = l1 + (l2-l1)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums,l1,mid-1);
        node.right = sortedArrayToBST(nums,mid+1,l2);
        return node;
    }
}