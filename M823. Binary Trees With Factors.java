class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        HashMap<Integer, Integer> map = new HashMap();
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) map.put(A[i],i);
    
        long num = 1;
        long[] dp = new long[A.length+1];
        for (int i = 1; i < A.length+1; i++) {
            dp[i] = 1;
        }
        for (int i = 2; i < A.length+1; i++) {
            for (int j = 1; j < i; j++) {
                if (A[j-1]*A[j-1] > A[i-1]) break;
                if(A[i-1] % A[j-1] == 0 && map.containsKey(A[i-1]/A[j-1])) {
                    if (A[j-1] != A[i-1]/A[j-1]) dp[i] += 2*dp[j]*dp[map.get(A[i-1]/A[j-1])+1]%(1000000000 + 7);
                    else dp[i] += dp[j]*dp[j];
                }
            }
            num+=dp[i];
            num%=1000000007;
        }
        return (int)num;
    }
}