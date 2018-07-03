class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> map = new TreeMap();
        for (int i = 0; i < position.length; i++) {
            map.put(target-position[i], (double)(target-position[i])/speed[i]);
        }
        int count = 0;
        double cur = -1.0;
        for (Map.Entry<Integer, Double> entry:map.entrySet()) {
            int dis = entry.getKey();
            double time = entry.getValue();
            if (time > cur) {
                count++;
                cur = time;
            }
        }
        return count;
    }
}