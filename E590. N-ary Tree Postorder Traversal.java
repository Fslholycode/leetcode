/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        Stack<Node> s = new Stack();
        s.push(root);
        List<Integer> res = new ArrayList();
        if (root == null) return res;
        while (!s.isEmpty()) {
            Node cur = s.pop();
            res.add(cur.val);
            for (Node child:cur.children) s.push(child);
        }
        Collections.reverse(res);
        return res;
    }
}