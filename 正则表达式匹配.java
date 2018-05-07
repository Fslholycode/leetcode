public class Solution {
    public boolean match(char[] str, char[] pattern) {
        int lens = str.length;
        int lenp = pattern.length;
        boolean[][] dp = new boolean[lens+1][lenp+1];
        dp[0][0] = true;
        for (int i = 1; i <= lenp; i++) {
            if(pattern[i - 1] == '*') dp[0][i] = dp[0][i - 2];
        }
        for (int i = 1; i <= lens; i++) {
            for (int j = 1; j <= lenp; j++) {
                if(pattern[j - 1] == '.' || pattern[j - 1] == str[i - 1]) dp[i][j] = dp[i - 1][j - 1];
                else if (pattern[j-1] == '*') {
                    if (str[i-1] != pattern[j-2] && pattern[j-2] != '.') dp[i][j] = dp[i][j-2];
                    else dp[i][j] = dp[i][j-1] || dp[i-1][j] || dp[i][j-2];
                }
            }
        }
        return dp[lens][lenp];
    }
}