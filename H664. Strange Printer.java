class Solution {
    public int strangePrinter(String s) {
        int len = s.length();
        int[][] dp = new int[len+1][len+1];

        for (int i = len; i > 0; i--) {
            for (int j = i; j < len+1; j++) {
                dp[i][j] = (i==j?1:1+dp[i+1][j]);
                for (int m = i+1; m <= j ; m++) {
                    if (s.charAt(m-1) == s.charAt(i-1)) dp[i][j] = Math.min(dp[i][j], dp[i+1][m-1]+dp[m][j]);
                }
            }
        }
        return (len==0?0:dp[1][len]);
    }
}