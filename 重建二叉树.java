/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return helper(pre, in, 0, pre.length-1, 0, in.length-1);
    }
    public TreeNode helper(int[] pre, int[] in, int pre_start, int pre_end, int in_start, int in_end) {
        //if (pre_start >= pre.length) return null;
        if (in_start > in_end || pre_start > pre_end) return null;
        TreeNode head = new TreeNode(pre[pre_start]);
        int index = find(pre[pre_start], in, in_start, in_end);
        int len = index-in_start;//2
        head.left = helper(pre, in, pre_start+1, pre_start+len, in_start, in_start+len-1);//1,2,0,1
        head.right = helper(pre, in, pre_start+len+1, pre_end, index+1, in_end);//3,5,3,5
        return head;
    }
    public int find(int target, int[] in, int in_start, int in_end) {
        for (int i = in_start; i <= in_end; i++) {
            if (in[i] == target) return i;
        }
        return -1;
    }
}