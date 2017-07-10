public class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        }
        return Math.max(dp[nums.length], dp[nums.length-1]);
    }
}