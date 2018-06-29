class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for (int n:nums) {
            count[n] += n;
        }
        int[] dp = new int[10003];
        for (int i = 10000; i >= 0; i--) {
            dp[i] = Math.max(dp[i+2]+count[i], dp[i+1]);
        }
        return dp[0];
    }
}