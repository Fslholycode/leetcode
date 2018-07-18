class Solution {
    private final Set<Integer> occupiedCols = new HashSet<Integer>();
    private final Set<Integer> occupiedDiag1s = new HashSet<Integer>();
    private final Set<Integer> occupiedDiag2s = new HashSet<Integer>();
    public int totalNQueens(int n) {
        int res = 0;
        return helper(res, 0, n);
    }
    public int helper(int res, int row, int n) {
        for (int i = 0; i < n; i++) {
            if (occupiedCols.contains(i)) continue;
            if (occupiedDiag1s.contains(i+row)) continue;
            if (occupiedDiag2s.contains(i-row)) continue;
            
            if (row == n-1) res++;
            else {
                occupiedCols.add(i);
                occupiedDiag1s.add(i+row);
                occupiedDiag2s.add(i-row);
                res = helper(res, row+1, n);
                occupiedCols.remove(i);
                occupiedDiag1s.remove(i+row);
                occupiedDiag2s.remove(i-row);
            }
        }
        return res;
    }    
}