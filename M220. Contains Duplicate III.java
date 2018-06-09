class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet();
        for (int i = 0; i < nums.length; i++) {
            Long big = set.floor((long)((long)nums[i]+t));
            Long small = set.ceiling((long)((long)nums[i]-t));
            if ((big != null && big >= (long)nums[i]) || (small != null && small <= (long)nums[i])) return true;
            set.add((long)nums[i]);
            if (i >= k) set.remove((long)nums[i-k]);
        }
        return false;
    }
}