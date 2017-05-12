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
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        postOrder(root, map);
        List<Integer> res = new LinkedList<>();
        for(Map.Entry<Integer, Integer> me: map.entrySet()){
            if(me.getValue() == max) res.add(me.getKey());
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
    public int postOrder(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int left = postOrder(root.left, map);
        int right = postOrder(root.right, map);
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum,0)+1);
        max = Math.max(max,map.get(sum));
        return sum;
    }
}