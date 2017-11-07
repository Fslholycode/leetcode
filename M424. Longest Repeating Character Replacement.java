class Solution {
    public int characterReplacement(String s, int k) {
        int lo = 0, hi;
        int[] count = new int[26];
        int maxcount = 0;
        int maxlength = 0;
        for (hi = 0; hi < s.length(); hi++) {
            maxcount = Math.max(maxcount, ++count[s.charAt(hi)-'A']);
            while (hi-lo+1-maxcount>k) {
                count[s.charAt(lo)-'A']--;
                lo++;
            }
            maxlength = Math.max(maxlength, hi-lo+1);
        }
        return maxlength;
    }
}