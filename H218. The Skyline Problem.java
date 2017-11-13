class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b:buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a,b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1]-b[1];
        });
        int prev = 0;
        Queue<Integer> q = new PriorityQueue<>((a, b) -> (b - a));
        q.offer(0);
        for (int[] h : height) {
            if (h[1] < 0) q.offer(-h[1]);
            else q.remove(h[1]);
            int cur = q.peek();
            if (prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
}