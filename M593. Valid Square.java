class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashMap<Integer, Integer> map = new HashMap();
        int[][] p = {p1, p2, p3, p4};
        for (int i = 0; i < 3; i++) {
            for (int j = i+1; j < 4; j++) {
                int dis = getDistance(p[i], p[j]);
                map.put(dis, map.getOrDefault(dis,0)+1);
            }
        }
        if (map.size() != 2) return false;
        int[] num = new int[2];
        int index = 0;
        
        for (Integer key : map.keySet()) {
            if (index == 2) return false; 
            num[index++] = key;
        }
        Arrays.sort(num);
        if (map.get(num[0]) == 4 && map.get(num[1]) == 2 && 2*num[0] == num[1]) return true;
        return false;
    }
    public int getDistance(int[] p1, int[] p2)  {
        return (int)(Math.pow((p1[0]-p2[0]),2)+Math.pow(p1[1]-p2[1], 2));
    }
}