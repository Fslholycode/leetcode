public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        helper(res, new ArrayList<Integer>(), nums, 0);
        List result = new ArrayList(res);
        return result;
    }
    public void helper(Set<List<Integer>> res, List<Integer> list, int[] nums, int pos) {
        //if (pos == nums.length) return;
        if (list.size() > 1) res.add(new ArrayList<Integer>(list));
        for (int i = pos; i < nums.length; i++) {
            if (list.size() == 0 || nums[i] >= list.get(list.size()-1)) {
                list.add(nums[i]);
                helper(res, list, nums, i+1);
                list.remove(list.size()-1);
            }
        }
    }
}