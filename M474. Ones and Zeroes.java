class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int res = 0;
        int[][] str = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                char c = strs[i].charAt(j);
                if (c == '1') str[i][1]++;
                else str[i][0]++;
            }
        }
        int[][] dp = new int[m+1][n+1];
        for (int k = 0; k < strs.length; k++) {
            for (int i = m; i >= str[k][0]; i--) {
                for (int j = n; j >= str[k][1]; j--) {
                    dp[i][j] = Math.max(1+dp[i-str[k][0]][j-str[k][1]], dp[i][j]);
                }
            }
            // dp[m][n]++;

        }
        return dp[m][n];
    }
}