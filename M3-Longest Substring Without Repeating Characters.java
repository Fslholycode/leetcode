public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0, fast = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (fast < s.length()) {
            char c = s.charAt(fast);
            if (set.contains(c)) {
                set.remove(s.charAt(slow));
                slow++;
            } else {
                set.add(c);
                max = Math.max(max,fast-slow+1);
                fast++;
            }
        }
        return max;
    }
}