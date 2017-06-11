public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        Helper(res, new ArrayList<Integer>(), nums, used);
        return res;
    }
    public void Helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue; //去掉重复的，因为前一位数字在之前用过，如果现在用就会重复
            list.add(nums[i]);
            used[i] = true;
            Helper(res,list,nums,used);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }
}