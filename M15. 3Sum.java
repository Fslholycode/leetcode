public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int left = i+1, right = nums.length-1;
            while (left < right) {
                int sum = nums[i]+nums[left]+nums[right];
                if (sum == 0) {
                    List<Integer> one = new ArrayList();
                    one.add(nums[i]);one.add(nums[left]);one.add(nums[right]);
                    res.add(one);
                    left++;
                    right--;
                    while (nums[left] == nums[left-1]) {
                        left++;
                        if (left >= right) break;
                    }
                    while (nums[right] == nums[right+1]) {
                        right--;
                        if (left >= right) break;
                    }
                } else if (sum < 0) left++;
                else right--;
            }
        }
        return res;
    }
}