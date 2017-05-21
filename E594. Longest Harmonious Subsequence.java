public class Solution {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int max = 0;
        for (int n : map.keySet()) {
            if (map.containsKey(n+1)) max = Math.max(max, map.get(n)+map.get(n+1));
        }
        return max;
    }
}