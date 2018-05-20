class Solution {
    int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) return 0;
        int m = forest.size(), n = forest.get(0).size();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    pq.add(new int[] {i, j, forest.get(i).get(j)});
                }
            }
        }
        int[] start = {0,0};
        int res = 0;
        while (!pq.isEmpty()) {
            int[] end = pq.poll();
            int step = helper(start, end, forest);
            if (step < 0) return -1;
            res+=step;
            start[0] = end[0];
            start[1] = end[1];
        }
        return res;
    }
    public int helper(int[] start, int[] end, List<List<Integer>> forest) {
    	    int step = 0;
        int m = forest.size(), n = forest.get(0).size();
    		Queue<int[]> queue = new LinkedList<>();
    		boolean[][] visited = new boolean[m][n];
        queue.add(start);
        while (!queue.isEmpty()) {
        	    int size = queue.size();
        	    for (int i = 0; i < size; i++) {
	        		int[] pos = queue.poll();
	        		// System.out.println(pos[0]+" "+pos[1]);
	        		if (pos[0] < 0 || pos[0] >= m || pos[1] < 0 || pos[1] >= n || visited[pos[0]][pos[1]] || forest.get(pos[0]).get(pos[1]) == 0) {
	        			continue;
	        		}
	        		// System.out.println(pos[0]+" "+pos[1]);
	        		visited[pos[0]][pos[1]] = true;
	        		if (pos[0] == end[0] && pos[1] == end[1]) return step;
	        		for (int j = 0; j < 4; j++) {
	        			int[] newpos = {pos[0]+dir[j][0], pos[1]+dir[j][1]}; 
	        			queue.offer(newpos);
	        		}
        	    }
        	    step++;
        }
        return -1;
    }
}