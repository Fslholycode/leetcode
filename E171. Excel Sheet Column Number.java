public class Solution {
    public int titleToNumber(String s) {
        int n = s.length()-1;
        int res = 0;
        int i = 0;
        
        while (i <= s.length()-1) {
            char c = s.charAt(i);
            res += Math.pow(26,n)*(c-'A'+1);
            i++;
            n--;
        }
        return res;
    } 
}