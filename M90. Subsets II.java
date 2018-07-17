public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        helper(nums, res, new ArrayList(), 0, null);
        return res;
    }
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> list, int pos, Integer pre) {
        res.add(new ArrayList(list));
        if (pos >= nums.length) return;
        for (int i = pos; i < nums.length; i++){
            if (pre != null && pre == nums[i]) continue;
            list.add(nums[i]);
            helper(nums, res, list, i+1, pre);
            pre = list.get(list.size()-1);
            list.remove(list.size()-1);
        }
    }
}