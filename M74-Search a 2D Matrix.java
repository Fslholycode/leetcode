public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        int start = 0;
        int end = m*n-1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            int row = mid/n;
            int col = mid%n;
            if (target == matrix[row][col]) return true;
            else if (target > matrix[row][col]) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (target == matrix[start/n][start%n] || target == matrix[end/n][end%n]) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
    	    int[][] matrix = {{}};
    	    int target = 1;
    	    System.out.println(new Solution().searchMatrix(matrix,target));
    }
}