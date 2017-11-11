public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String res = "";
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i-1) != ' ' && s.charAt(i) == ' ') {
                res = s.substring(index+1,i)+" "+res;
            }
            if (s.charAt(i) == ' ') index = i;
        }
        res = s.substring(index+1)+" "+res;
        return res.trim(); 
    }
}