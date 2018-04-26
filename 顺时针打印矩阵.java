import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList();
        int start_row = 0;
        int end_row = matrix.length-1;
        int start_col = 0;
        int end_col = matrix[0].length-1;
        while (start_row<=end_row && start_col<=end_col) {
            for (int i = start_col; i <= end_col; i++) {
                res.add(matrix[start_row][i]);
            } 
            start_row++;
            for (int i = start_row; i<= end_row; i++) {
                res.add(matrix[i][end_col]);
            }
            end_col--;
            if (start_row <= end_row&&start_col <=end_col){
                for (int i = end_col; i>=start_col; i--) {
                    res.add(matrix[end_row][i]);
                }
                end_row--;
                for (int i = end_row; i>=start_row; i--) {
                    res.add(matrix[i][start_col]);
                }
                start_col++;
            }
        }
        return res;
    }
}