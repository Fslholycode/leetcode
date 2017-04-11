import java.util.Hashtable;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLength = 1;
        int index1 = 0;
        int index2 = -1;
        int nowmax = 0;
        Hashtable<Character,Integer> ht = new Hashtable<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (ht.containsKey(key)) {
                maxLength = Math.max(nowmax, maxLength);
                index1 = Math.max(ht.get(key)+1,index1);
                index2++;
                nowmax = index2-index1+1;
                ht.remove(key);
                ht.put(key,i);
            }
            else {
                ht.put(key, i);
                nowmax++;
                index2++;
            }
        }
        return Math.max(maxLength, nowmax);
    }
    public static void main(String[] args) {
    	    String a = "abba";
    	    System.out.println(new Solution().lengthOfLongestSubstring(a));
    }
}