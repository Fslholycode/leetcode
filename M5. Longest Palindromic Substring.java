public class Solution {
    public String longestPalindrome(String s) {
        int len = 1;
        if (s.length() <= 1) return s;
        String res = s.substring(0,1);
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                List<Integer> prev = map.get(c);
                for (int index : prev) {
                    if (index + 1 == i || dp[index+1][i-1]) {
                        dp[index][i] = true;
                        if (i-index+1 > len) {
                            res = s.substring(index,i+1);
                            len = i-index+1;
                        }
                         
                    }
                }
                map.get(c).add(i);
            } else {
                map.put(c, new ArrayList());
                map.get(c).add(i);
            }
        }
        return res;
    }
}