/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    TreeNode leftlast = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        
        TreeNode left = Convert(pRootOfTree.left);
        if (leftlast == null) {
            leftlast = pRootOfTree;
        } else {
            leftlast.right = pRootOfTree;
            pRootOfTree.left = leftlast;
            leftlast = pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return left==null? pRootOfTree:left;
    }
}