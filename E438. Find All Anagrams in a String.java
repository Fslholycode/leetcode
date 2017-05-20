public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < s.length()-p.length()+1; i++) {
            boolean goal = true;
            int[] alpha = new int[26];
            for (int j = 0; j < p.length(); j++) {
                alpha[p.charAt(j)-'a']++;
            }
            for (int j = 0; j < p.length(); j++) {
                alpha[s.charAt(i+j)-'a']--;
            }
            for (int j = 0; j < 26; j++) {
                if (alpha[j] != 0) {
                    goal = false;
                    break;
                }
            }
            if (goal) res.add(i);
        }
        return res;
    }
}