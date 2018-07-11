class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        if (k == 0 || nums.length == 0)  return new int[0]; 
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        res[0] = pq.peek();
        for (int i = k; i < nums.length; i++) {
            pq.remove(nums[i-k]);
            pq.add(nums[i]);
            res[i-k+1] = pq.peek();
        }
        return res;
    }
}