public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0) return nums;
        int m = nums.length;
        if (nums[0].length == 0) return nums;
        int n = nums[0].length;
        if (m*n != r*c) return nums;
        int[][] res = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = nums[index/n][index%n]; 
                index++;
            }
        }
        return res;
    }
}