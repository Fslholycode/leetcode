public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i+1 < nums.length && nums[i] == 0 && nums[i+1] == 0) return true;
            sum += nums[i];
            if (k != 0) sum %= k;
            if (map.containsKey(sum)) {
                if (i-map.get(sum)>1) return true;
            } else {
                map.put(sum,i);
            }
        }
        return false;
    }
}