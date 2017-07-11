public class NumMatrix {
    int[][] nums;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;   
        }
        int len = matrix.length;
        int wid = matrix[0].length;
        nums = new int[len][wid];
        nums[0][0] = matrix[0][0];
        for (int i = 1; i < len; i++) nums[i][0] = nums[i-1][0] + matrix[i][0];
        for (int i = 1; i < wid; i++) nums[0][i] = nums[0][i-1] + matrix[0][i];
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < wid; j++) {
                nums[i][j] = nums[i-1][j] + nums[i][j-1] + matrix[i][j] - nums[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) return nums[row2][col2];
        if (row1 == 0) return nums[row2][col2] - nums[row2][col1-1];
        if (col1 == 0) return nums[row2][col2] - nums[row1-1][col2];
        return nums[row2][col2] - nums[row2][col1-1] - nums[row1-1][col2] + nums[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */