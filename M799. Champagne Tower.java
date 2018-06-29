class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] cups = new double[100][100];
        cups[0][0] = (double)poured;
        for (int i = 0; i < cups.length-1; i++) {
            for (int j = 0; j <= i; j++) {
                if (cups[i][j] > 1) {
                    cups[i+1][j] += (cups[i][j]-1)/2;
                    cups[i+1][j+1] += (cups[i][j]-1)/2;
                    cups[i][j] = 1.0;
                }
            }
        }
        return cups[query_row][query_glass];
    }
}