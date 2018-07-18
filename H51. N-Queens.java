class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] visited = new boolean[n][n];
        List<List<String>> res = new ArrayList();
        helper(n, res, visited, 0, new ArrayList());
        return res;
    }
    public void helper(int n, List<List<String>> res, boolean[][] visited, int row, List<String> list) {
        if (list.size() == n) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(n, visited, row, i)) {
                visited[row][i] = true;
                list.add(build(n,i));
                helper(n, res, visited, row+1, list);
                visited[row][i]= false;
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isValid(int n, boolean[][] visited, int x, int y) {
        for (int i = 0; i <= x; i++) {
            if (visited[i][y]) return false;
        }
        for (int i = x,j=y;i>=0&&j>=0;i--,j--) {
            if (visited[i][j]) return false;
        }
        for (int i = x,j=y;i>=0&&j<n;i--,j++) {
            if (visited[i][j]) return false;
        }
        return true;
    } 
    public String build(int n, int index) {
        String s = "";
        for (int i = 0; i < n; i++) {
            if (i != index) s += ".";
            else s+="Q";
        }
        return s;
    }
}