public class Solution {
    public int findMaxLength(int[] nums) {
        int length = 0, nums0 = 0, nums1 = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums0++;
            } else {
                nums1++;
            }
            int num = nums0-nums1;
            if (map.containsKey(num)) {
                length = Math.max(length, i - map.get(num));
            } else {
                map.put(num,i);
            }
        }
        return length;
    }
}