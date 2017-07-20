public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) res[i][j] = 0;
                else {
                    int left = Integer.MAX_VALUE-1;
                    int top = Integer.MAX_VALUE-1;
                    if (i-1>=0) top = res[i-1][j];
                    if (j-1>=0) left = res[i][j-1];
                    res[i][j] = Math.min(Integer.MAX_VALUE-1, Math.min(left,top)+1);
                }
            }
        }
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                if (res[i][j] != 0 && res[i][j] != 1) {
                    int down = Integer.MAX_VALUE-1;
                    int right = Integer.MAX_VALUE-1;
                    if (i+1 <= n-1) right = res[i+1][j];
                    if (j+1 <= m-1) down = res[i][j+1];
                    res[i][j] = Math.min(res[i][j], Math.min(right,down)+1);
                }
            }
        }
        return res;
    }
}