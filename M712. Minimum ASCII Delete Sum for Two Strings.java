class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0; i < len1; i++) {
            dp[i+1][0] = dp[i][0]+s1.charAt(i)-'a'+97;
        }
        for (int j = 0; j < len2; j++) {
            dp[0][j+1] = dp[0][j]+s2.charAt(j)-'a'+97;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(dp[i-1][j-1]+s2.charAt(j-1)-'a'+97+s1.charAt(i-1)-'a'+97,Math.min(dp[i][j-1]+s2.charAt(j-1)-'a'+97, dp[i-1][j]+s1.charAt(i-1)-'a'+97));
            }
        }
        return dp[len1][len2];
    }
}