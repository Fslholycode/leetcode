public class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length]; //dp[i] 代表以i结尾的最大子数列和
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] < 0) {
                dp[i] = nums[i];
            }
            else {
                dp[i] = dp[i-1] + nums[i];
            }
        }
        int res = dp[0];
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(dp[i],res);
        }
        return res;
    }
}