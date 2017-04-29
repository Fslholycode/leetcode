public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n <= 0) return res;
        int rows = 0;
        int rowe = n-1;
        int cols = 0;
        int cole = n-1;
        int num = 1;
        while (rows <= rowe && cols <= cole) {
            for (int i = cols; i <= cole; i++) {
                res[rows][i] = num++;
            }
            rows++;
            for (int i = rows; i <= rowe; i++) {
                res[i][cole] = num++;
            }
            cole--;
            for (int i = cole; i >= cols; i--) {
                res[rowe][i] = num++;
            }
            rowe--;
            for (int i = rowe; i >= rows; i--) {
                res[i][cols] = num++;
            }
            cols++;
        }
        return res;
    }

    public static void main(String[] args) {
    	    int n = 3;
    	    int[][] result = new Solution().generateMatrix(n);
    	    for (int i = 0; i < n; i++) {
    	    	    for (int j = 0; j < n; j++) {
    	    	    	    System.out.print(result[i][j]+" ");
    	    	    }
    	    	    System.out.println("\n");
    	    }
    }
}