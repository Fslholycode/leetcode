class Solution {
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int res = m*(1<<(n-1));
        // System.out.println(res);
        for (int i = 1; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (A[j][i] == A[j][0]) count++;
            }
            res += (1<<(n-i-1))*Math.max(count, m-count);
            // System.out.println(res);
        }
        return res;
    }
}