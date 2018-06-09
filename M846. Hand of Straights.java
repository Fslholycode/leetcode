class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> map = new TreeMap();
        for (int h : hand) map.put(h, map.getOrDefault(h,0)+1);
        for (int i : map.keySet()) {
            int count = map.get(i);
            if (count == 0) continue;
            for (int j = i; j < i+W; j++) {
                Integer num = map.get(j);
                if (num == null || num < count) return false;
                map.put(j, num-count);
            }
        }
        return true;
    }
}