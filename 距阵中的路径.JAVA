public class Main {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[][] visited =  new boolean[rows][cols];
        char[][] charmatrix = new char[rows][cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                charmatrix[i][j] = matrix[index++];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0 ; j < cols; j++) {                    
                if (dfs(charmatrix, rows, cols, i, j, str, 0, visited)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] matrix, int rows, int cols, int x, int y, char[] str, int pos, boolean[][] visited) {
        if (pos == str.length) return true;
        if (x < rows && x >= 0 && y >= 0 && y < cols && !visited[x][y] && matrix[x][y] == str[pos]) {
	    	    System.out.println(matrix[x][y]);
	    	    visited[x][y] = true;
	    	    for (int i = 0; i < 4; i++) {
	    	    		int newx = x+dir[i][0];
	            int newy = y+dir[i][1];
	    	    		if (dfs(matrix, rows, cols, newx, newy, str, pos+1, visited)) return true;
	    	    }
	        visited[x][y] = false;
	    }
        return false;
    }
    public static void main(String[] args) {
    		char[] matrix = {'A'};
    		int rows = 1;
    		int cols = 1;
    		char[] str = {'A'};
    		System.out.println(new Main().hasPath(matrix, rows, cols, str));
    }
}