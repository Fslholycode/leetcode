class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1 && !isValid(graph, colors, 0, i)) return false;
        }
        return true;
    }
    public boolean isValid(int[][] graph, int[] colors, int color, int next) {
        if (colors[next] != -1) return colors[next] == color;
        colors[next] = color;
        for (int num:graph[next]){
            if (!isValid(graph, colors, 1-color, num)) return false;
        }
        return true;
    }
}

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        Arrays.fill(visited, -1);
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length != 0 && visited[i] == -1) {
                visited[i] = 0;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while (!q.isEmpty()) {
                    int size = q.size();
                    for (int j = 0; j < size; j++) {
                        int cur = q.poll();
                        for (int next:graph[cur]) {
                            if (visited[next] == visited[cur]) return false;
                            if (visited[next] == -1) q.add(next);
                            visited[next] = 1-visited[cur];
                        }
                    }
                }
            }
        }
        return true;
    }
}