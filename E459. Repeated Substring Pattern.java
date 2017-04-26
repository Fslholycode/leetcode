public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        for (int i = 1; i < l; i++) {
            if (l%i == 0) {
                String sub = s.substring(0,i);
                StringBuilder sb = new StringBuilder();
                int k = l/i;
                while(k > 0) {
                    sb.append(sub);
                    k--;
                }
                if (sb.toString().equals(s)) return true;
            }
        }
        return false;
    }
}