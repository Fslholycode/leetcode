public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if (points.length < 3 || points[0].length < 2) return 0;
        int count = 0;

        for (int i = 0; i < points.length; i++) {
            Map<Integer,Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                int dis = distance(points,i,j);
                if (dis == 0) continue;
                map.put(dis, map.getOrDefault(dis,0)+1);
            }
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
        	    int num = entry.getValue();
        		if (num > 1) {
        			count += num*(num-1);
        		}
            }
            
        }
        return count;
    }
    public int distance(int[][] points, int i, int j) {
        return (points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
    }
}