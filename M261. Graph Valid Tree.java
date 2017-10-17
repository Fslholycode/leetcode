class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] num = new int[n];
        Arrays.fill(num, -1);
        for (int i = 0; i < edges.length; i++) {
            int x = find(num, edges[i][0]);
            int y = find(num, edges[i][1]);
            if (x == y) return false;
            num[y] = x;
        }
        return edges.length == n-1;
    }
    public int find(int[] num, int index) {
        if (num[index] == -1) return index;
        return find(num, num[index]);
    }
}