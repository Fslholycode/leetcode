/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = "";
        if (root == null) return "null";
        res+=Integer.toString(root.val)+",";
        res+=serialize(root.left)+",";
        res+=serialize(root.right)+",";
        // System.out.println(res);
        for (int i = 1; i < res.length(); i++) {
            if (res.charAt(i) == res.charAt(i-1) && res.charAt(i) == ',') res = res.substring(0, i)+res.substring(i+1);
        }
        // System.out.println(res);

        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nums = data.split(",");
        return helper(nums, 0, nums.length-1);
    }
    
    public TreeNode helper(String[] nums, int left, int right) {
        if (left >= nums.length || nums[left].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nums[left]));
        Integer index = null;
        for (int i = left+1; i <= right; i++) {
            if (nums[i].equals("null")) continue;
            if (Integer.parseInt(nums[i]) > root.val) {
                index = i;
                break;
            }
        }
        if (index == null) {
            root.right = null;
            root.left = helper(nums, left+1, right);
        } else {
            root.right = helper(nums, index, right);
            root.left = helper(nums, left+1, index-1);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));