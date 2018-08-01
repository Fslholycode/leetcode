class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, new HashMap<String, List<String>>());
    }
    
    public List<String> helper(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) return map.get(s);
        List<String> res = new ArrayList();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String str : wordDict) {
            if (s.startsWith(str)) {
                List<String> next = helper(s.substring(str.length()), wordDict, map);
                for (String sub:next) {
                    res.add(str+(sub.isEmpty()?"":" ")+sub);
                }                       
            }
        }
        map.put(s, res);
        return res;
    }
}