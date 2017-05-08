public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums.length == 0) return res;
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        int num1 = nums[0], num2 = nums[1];
        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == num1) count1++;
            else if (num == num2) count2++;
            else if (count1 == 0) {
                count1 = 1;
                num1 = num;
            } 
            else if (count2 == 0) {
                count2 = 1;
                num2 = num;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
    	count2 = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] == num1)
    			count1++;
    		else if (nums[i] == num2)
    			count2++;
    	}
    	if (count1 > nums.length / 3)
    		res.add(num1);
    	if (count2 > nums.length / 3)
    		res.add(num2);
    	return res;
    }
}