public class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int premax = nums[0];
        int premin = nums[0];
        int nowmax, nowmin;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                nowmax = Math.max(premin*nums[i], nums[i]);
                nowmin = Math.min(premax*nums[i], nums[i]);
            }
            else {
                nowmax = Math.max(premax*nums[i], nums[i]);
                nowmin = Math.min(premin*nums[i], nums[i]);
            }
            premin = nowmin;
            premax = nowmax;
            max = Math.max(nowmax, max);
        }
        return max;
    }
}