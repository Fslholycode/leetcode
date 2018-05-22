class Solution {
    public int minStickers(String[] stickers, String target) {
        int m = stickers.length;
        int[][] mp = new int[m][26];
        Map<String, Integer> dp = new HashMap<>();
        for (int i = 0; i < m; i++) 
            for (char c:stickers[i].toCharArray()) mp[i][c-'a']++;
        dp.put("", 0);
        return helper(dp, mp, target);
    }
    private int helper(Map<String, Integer> dp, int[][] mp, String target) {
        if (dp.containsKey(target)) return dp.get(target);
        int[] tar = new int[26];
        int res = Integer.MAX_VALUE;
        for (char c:target.toCharArray()) tar[c-'a']++;
        for (int i = 0; i < mp.length; i++) {
            if (mp[i][target.charAt(0)-'a'] == 0) continue;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (tar[j] > 0) {
                    for (int k = 0; k < Math.max(0, tar[j]-mp[i][j]); k++) sb.append((char)(j+'a'));
                }
            }
            int next = helper(dp, mp, sb.toString());
            if (next != -1)  res = Math.min(res, 1+next);
        }
        dp.put(target, res == Integer.MAX_VALUE?-1:res);
        return dp.get(target);
    }
}