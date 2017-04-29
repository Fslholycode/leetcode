public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Helper(res, new ArrayList<Integer>(), nums, 0);
        res.add(new ArrayList<Integer>());
        return res;
    }
    public void Helper(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int pos) {
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            res.add(new ArrayList(list));
            Helper(res, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }
}