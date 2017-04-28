public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        int[] res = new int[2];
        while (numbers[left] + numbers[right] != target) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        res[0]=left+1;
        res[1]= right+1;
        return res;
    }
}