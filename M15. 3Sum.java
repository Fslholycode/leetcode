public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int low = i+1, high = nums.length-1;
            while (low < high) {
                int sum = nums[low] + nums[high] + nums[i];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[low],nums[high],nums[i]));
                    while (low < high && nums[low] == nums[low+1]) low++;
                    while (low < high && nums[high] == nums[high-1]) high--;
                    low++;
                    high--;
                }
                else if (sum < 0) low++;
                else high--;
            }
        }
        return res;
    }
}