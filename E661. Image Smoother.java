class Solution {
    int rows;
    int cols;
    public int[][] imageSmoother(int[][] M) {
        if (M == null) return null;
        rows = M.length;
        if (rows == 0) return new int[0][];
        cols = M[0].length;
        
        int[][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int count = 0;
                int sum = 0;
                for (int incR : new int[]{-1, 0, 1}) {
                    for (int incC : new int[]{-1, 0, 1}) {
                        if (isValid(i + incR, j + incC, rows, cols)) {
                            count++;
                            sum += get(M,i + incR,j + incC);
                        }
                    }
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
    public int get(int[][] M, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return 0;
        } else return M[row][col];
    }
    private boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}