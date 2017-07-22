public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;
        int n = 0, m = 0;
        while (m < t.length()) {
            if (s.charAt(n) != t.charAt(m)) m++;
            else {
                n++;
                m++;
            }
            if (n == s.length()) return true;
        }
        return false;
    }
}