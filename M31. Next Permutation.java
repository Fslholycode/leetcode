public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        for (int i = nums.length-1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                for (int j = nums.length-1; j >= i; j--) {
                    if (nums[j] > nums[i-1]) {
                        swap(nums, j, i-1);
                        reverse(nums, i);
                        break;
                    }
                }
                return;
            }
        }
        reverse(nums, 0);
    }
    public void swap(int[] nums, int a, int b) {
        int item = nums[a];
        nums[a] = nums[b];
        nums[b] = item;
    }
    private void reverse(int[] a,int i){//reverse the number after the number we have found
        int first = i;
        int last = a.length-1;
        while(first<last){
            int t = a[first];
            a[first] = a[last];
            a[last] = t;
            first ++;
            last --;
        }
    }
}