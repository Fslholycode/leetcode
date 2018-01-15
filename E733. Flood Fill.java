class Solution {
    int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        helper(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    public void helper(int[][] image, int sr, int sc, int newColor, int color) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        for (int i = 0; i < 4; i++) {
            helper(image, sr+dir[i][0], sc+dir[i][1], newColor, color);
        }
    }
}