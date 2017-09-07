class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();        
        helper(res, nums, 0, new ArrayList<Integer>());
        return res;
    }
    public void helper(List<List<Integer>> res, int[] nums, int index, ArrayList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list)); 
            return;
        }
        for (int i = 0; i <= list.size(); i++) {
            ArrayList<Integer> newlist = new ArrayList<>(list);
            newlist.add(i, nums[index]);
            helper(res, nums, index+1, newlist);
        }
    }
}