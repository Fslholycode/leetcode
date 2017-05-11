public class Solution {
    public int distributeCandies(int[] candies) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num:candies) {
            if (set.add(num)) count++;
        }
        return count >= candies.length/2? candies.length/2:count;
    }
}