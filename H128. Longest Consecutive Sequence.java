public class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = map.containsKey(n-1)? map.get(n-1):0;
                int right = map.containsKey(n+1)? map.get(n+1):0;
                int sum = left+right+1;//don't forget to add this line
                map.put(n,sum);
                res = Math.max(res, sum);
                map.put(n-left, sum);
                map.put(n+right, sum);
            } else {
                continue;
            }
        }
        return res;
    }
}