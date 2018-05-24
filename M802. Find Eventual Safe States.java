class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList();
        int m = graph.length;
        int n = graph[0].length;
        int[] mark = new int[m];
        for (int i = 0; i < m; i++) {
            if (dfs(i, graph, mark)) res.add(i);
        }
        return res;
    }
    public boolean dfs(int num, int[][] graph, int[] mark) {
        if (mark[num] != 0) return mark[num] == 1;
        mark[num] = 2;
        for (int i : graph[num]) {
            if (!dfs(i, graph, mark)) return false;
        }
        mark[num] = 1;
        return true;
    }
}