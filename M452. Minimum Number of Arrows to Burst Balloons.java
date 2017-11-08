class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (a,b) -> (a[1]-b[1]));
        Arrays.sort(points, (a,b) -> (a[0]-b[0]));
        int res = 1;
        int prev = points[0][1];
        for (int i = 0; i < points.length-1; i++) {
            
            if (prev >= points[i+1][0]) {
                prev = Math.min(points[i+1][1], prev);
            }
            else {
                prev = points[i+1][1];
                res++;
            }
        }
        return res;
    }
}