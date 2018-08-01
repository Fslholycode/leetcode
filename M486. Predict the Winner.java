class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int sum = 0;
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
            sum+=nums[i];
        }
        for (int i = 0; i < len-1; i++) {
            dp[i][i+1] = Math.max(nums[i],nums[i+1]);
        }
        for (int j = 2; j < len; j++) {
            for (int i = j-2; i >= 0; i--) {
                dp[i][j] = Math.max(Math.min(dp[i+1][j-1], dp[i+2][j])+nums[i], Math.min(dp[i+1][j-1], dp[i][j-2])+nums[j]);
            }
        }
        return 2*dp[0][len-1] >= sum;
    }
}