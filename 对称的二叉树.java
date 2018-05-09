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
//递归
public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return helper(pRoot.left, pRoot.right);
    }
    boolean helper(TreeNode left, TreeNode right) {
        if (left == null) return right == null;
        if (right == null) return false;
        if (left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}

//遍历
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
import java.util.Queue;
import java.util.LinkedList;
public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        Queue<TreeNode> q1 = new LinkedList();
        Queue<TreeNode> q2 = new LinkedList();
        q1.offer(pRoot.left);
        q2.offer(pRoot.right);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode left = q1.poll();
            TreeNode right = q2.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            q1.offer(left.left);
            q1.offer(left.right);
            q2.offer(right.right);
            q2.offer(right.left);
        }
        return true;
    }
}