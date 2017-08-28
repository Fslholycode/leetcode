class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true; 
        if (s1.length() != s2.length()) return false;
        int[] letter = new int[26];
        
        for (int i = 0; i < s1.length(); i++) {
            letter[s1.charAt(i) - 'a']++;
            letter[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (letter[i] != 0) return false;
        }
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i))) return true;
            if (isScramble(s1.substring(0,i), s2.substring(s2.length()-i)) && isScramble(s1.substring(i), s2.substring(0,s2.length()-i))) return true;
        }
        return false;
    }
}