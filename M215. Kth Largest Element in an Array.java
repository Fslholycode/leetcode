import java.util.Random;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        return partition(nums, 0, nums.length - 1, k);
    }
    
    public int partition(int[] nums, int start, int end, int k) {
    		Random rand = new Random();
        int index = rand.nextInt(end - start + 1) + start;
        int pivot = nums[index];
        swap(nums, index, end);
        index = start;
        for (int i = start; i <= end; i++) {
        		if (nums[i] >= pivot) swap(nums, index++, i);
        }
        if (index-start == k) return pivot;
        else if (index- start > k) return partition(nums, start, Math.min(end-1, index),k);
        else return partition(nums, index, end, k-index+start);
        
    }
    

    public void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = nums.length-1; i >= 0; i--) {
            int j = random.nextInt(i+1);
            swap(nums, i, j);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
    		int[] nums = {99,99};
    		int k = 1;
    		System.out.println(new Solution().findKthLargest(nums, k));
    		for (int i = 0; i < nums.length; i++) {
    			System.out.println(nums[i]);
    		}
    }
}