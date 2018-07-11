class Solution {
    public int numTilings(int N) {
        long[] dp = new long[N+1];
        if (N <= 1) return N;
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i-3]+2*dp[i-1])%1000000007;
        }
        return (int)dp[N];
    }
}