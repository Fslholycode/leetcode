public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int length = 0;
        for (int num : wall.get(0)) {
            length += num;
        }
        for (List<Integer> onerow: wall) {
            int sum = 0;
            for (int num : onerow) {
                sum += num;
                if (sum == length) continue;
                map.put(sum, map.getOrDefault(sum,0)+1);
                max = Math.max(max,map.get(sum));
            }
        }
        return wall.size()-max;
    }
}