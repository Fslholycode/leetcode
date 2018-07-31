class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        char[] arr1 = s.toCharArray();
        char[] arr2 = p.toCharArray();
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for (int i = 1; i <= len2; i++) {
            if (arr2[i-1] == '*' && dp[0][i-2]) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (arr2[j-1] == '*') {
                    if (arr2[j-2] == '.' || arr2[j-2] == arr1[i-1])
                        dp[i][j] = dp[i][j-2]||dp[i-1][j]||dp[i][j-1];
                    else dp[i][j] = dp[i][j-2];
                } else if (arr2[j-1] == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (arr1[i-1] == arr2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[len1][len2];
    }
}