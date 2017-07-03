public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int cur = 0;
        for(int i=0;i<s.length();i++) {
            if (isPalindrome(s, i-cur-1, i)) {
                res = s.substring(i-cur-1, i+1);
                cur = cur+2;
            }
            else if (isPalindrome(s, i-cur, i)) {
                res = s.substring(i-cur, i+1);
                cur = cur+1;
            }
        }
        return res;
    }
    public boolean isPalindrome(String s, int begin, int end){
        if(begin<0) return false;
        while(begin<end){
        	if(s.charAt(begin++)!=s.charAt(end--)) return false;
        }
        return true;
    }
}