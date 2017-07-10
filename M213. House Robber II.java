public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(Helper(nums,0,nums.length-2), Helper(nums,1,nums.length-1));
    }
    public int Helper(int[] nums, int lo, int hi) {
        int len = hi -lo + 1;
        if (len == 1) return nums[lo];
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = nums[lo];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i-2] + nums[lo+i-1],dp[i-1]);
        }
        return Math.max(dp[len], dp[len-1]);
    }
}