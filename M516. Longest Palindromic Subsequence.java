public class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (s == null || s.length() == 0) return 0;
        int[][] dp = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int j = 0; len+j <= n; j++) {
                int rhs = len+j-1;
                if (len == 1) {
                    dp[j][rhs] = 1;
                } else if (len == 2) {
                    dp[j][rhs] = (s.charAt(j) == s.charAt(rhs))? 2:1;
                } else {
                    int add = s.charAt(j) == s.charAt(rhs)? 2:0;
                    dp[j][rhs] = Math.max(dp[j][rhs-1],Math.max(dp[j+1][rhs], dp[j+1][rhs-1]+add));
                }
            }
        }
        return dp[0][n-1];
    }
}