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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, inorder, 0, inorder.length-1);
    }
    public TreeNode helper(int[] preorder, int pre, int[] inorder, int left2, int right2) {
        // System.out.println(left1 +" "+right1+" "+left2+" "+right2);

        if (pre >= preorder.length || left2 > right2) return null;
        int root = preorder[pre];
        int index = left2;
        for (;index <= right2; index++) {
            if (inorder[index]== root) break;
        }
        TreeNode node = new TreeNode(root);
        // System.out.println(left1 +" "+right1+" " +index+" "+left2+" "+right2);
        node.left = helper(preorder, pre+1, inorder, left2, index-1);
        node.right = helper(preorder, pre+index-left2+1, inorder, index+1, right2);
        // node.right = helper(preorder, index+1, inorder, index+1, right2);
        return node;
    }
}