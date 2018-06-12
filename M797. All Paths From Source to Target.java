class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> list = new ArrayList();
        boolean[] visited = new boolean[graph.length];
        visited[0] = true;
        list.add(0);
        helper(graph, res, list, 0, visited);
        return res;
    }
    public void helper(int[][] graph, List<List<Integer>> res, List<Integer> list, int pos, boolean[] visited) {
        if (pos == graph.length-1) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < graph[pos].length; i++) {
            if (!visited[graph[pos][i]]) {
                list.add(graph[pos][i]);
                visited[graph[pos][i]] = true;
                helper(graph, res, list, graph[pos][i], visited);
                list.remove(list.size()-1);
                visited[graph[pos][i]] = false;
            }
        }
        return;
    } 
}