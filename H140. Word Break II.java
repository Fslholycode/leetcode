class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (!iswordBreak(s, wordDict)) return new ArrayList();
        Map<String, Integer> map = new HashMap<>();
        map.put("", 0);
        ArrayList<String> list = new ArrayList();
        ArrayList<String> as = new ArrayList();
        as.add("");
        ArrayList<String> prev = new ArrayList(as);
        for (int i = 1; i <= s.length(); i++) {
            for (String str : prev) {
                String cur = s.substring(map.get(str),i);
                if (wordDict.contains(cur)) {
                    cur = str+" "+cur;
                    map.put(cur, i);
                    as.add(cur);
                    if (i == s.length()) list.add(cur);
                }      
            }
            prev = new ArrayList(as);
        }
        List<String> res = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            res.add(list.get(i).trim());
        }
        return res;
    }
    public boolean iswordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }       
            }
        }
        return dp[s.length()];
    }
}