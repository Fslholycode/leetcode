public class Solution {
    public boolean canCross(int[] stones) {
        int num = stones.length;
        HashMap<Integer, HashSet<Integer>> map = new HashMap();
        for (int i = 0; i < num; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(1);
        for (int i = 0; i < num-1; i++) {
            int stone = stones[i];
            for (int step: map.get(stone)) {
                int dis = stone+step;
                if (dis == stones[num-1]) return true;
                HashSet<Integer> set = map.get(dis);
                if (set != null) {
                    map.get(dis).add(step);
                    if (step-1 > 0) map.get(dis).add(step-1);
                    map.get(dis).add(step+1);
                }
            }
        }
        return false;
    }
}