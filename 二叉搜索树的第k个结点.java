/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
import java.util.Stack;
public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot==null||k==0)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (pRoot != null || !stack.isEmpty()) {
            while (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            pRoot = stack.pop();
            k--;
            if (k == 0) return pRoot;
            pRoot = pRoot.right;
        } 
        return null;
    }
}

//递归
public class Solution {
    int count = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot==null||k==0)
            return null;
        TreeNode node = KthNode(pRoot.left, k);
        if (node != null) return node;
        if (++count == k) return pRoot;
        TreeNode n = KthNode(pRoot.right, k);
        if (n != null) return n;
        return null;
    }
}