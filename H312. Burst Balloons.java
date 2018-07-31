class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = j; i >= 0; i--) {
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], (i <= k - 1 ? dp[i][k - 1] : 0)
                        + (k + 1 <= j ? dp[k + 1][j] : 0)
                        + (i - 1 >= 0 ? nums[i - 1] : 1) * nums[k]
                        * (j + 1 < len ? nums[j + 1] : 1));
                }
            }
        }
        return dp[0][len-1];
    }
}