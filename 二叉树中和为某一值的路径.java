import java.util.ArrayList;
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
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if (root == null) return res;
        ArrayList<Integer> list  = new ArrayList();
        helper(res, list, root, target);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, TreeNode root, int target) {
        list.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) res.add(new ArrayList(list));
        if (target < 0) return;
        if (root.left != null) helper(res, new ArrayList(list), root.left, target);
        if (root.right != null) helper(res, new ArrayList(list), root.right, target);
    }
}

//精简版本

public class Solution {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }
}