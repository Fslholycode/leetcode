int LCSLinearSpace(string a,string b){
  // Find lengths of two strings
    int m = a.length(), n = b.length();
  
  if(m<n) return LCSLinearSpace(b,a);

    vector<vector<int> > dp(2,vector<int>(n+1,0));
    bool line = true;
 
    for (int i=0; i<=m; i++)
    {
        // Compute current binary index
        line = !line;
 
        for (int j=0; j<=n; j++)
        {
            if (i == 0 || j == 0)
                dp[line][j] = 0;
 
            else if (a[i] == b[j])
                dp[line][j] = dp[1-line][j-1] + 1;
 
            else
                dp[line][j] = max(dp[1-line][j], dp[line][j-1]);
        }
    }
 
    /* Last filled entry contains length of LCS
       for X[0..n-1] and Y[0..m-1] */
    return dp[line][n];
}