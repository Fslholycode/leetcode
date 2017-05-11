public class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                set.remove(c);
                count++;
            } else {
                set.add(c);
            }
        }
        return set.isEmpty()? 2*count:2*count+1;
    }
}