import java.util.ArrayList;

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
import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if (pRoot == null) return res;
        int depth = 0;
        Queue<TreeNode> q = new LinkedList();
        Queue<TreeNode> cur = new LinkedList();
        cur.offer(pRoot);
        while (!cur.isEmpty()) {
            q = cur;
            cur = new LinkedList();
            depth++;
            ArrayList<Integer> arr = new ArrayList();
            Stack<Integer> s = new Stack();
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                s.push(node.val);
                if (node.left != null) cur.offer(node.left);
                if (node.right != null) cur.offer(node.right);
            }
            if (depth%2 == 1) {
                Stack<Integer> s1 = new Stack();
                while (!s.isEmpty()) {
                    s1.push(s.pop());
                }
                while (!s1.isEmpty()) {
                    arr.add(s1.pop());
                }
            } else {
                while (!s.isEmpty()) {
                    arr.add(s.pop());
                }
            }
            res.add(arr);
        }
        return res;
    }

}