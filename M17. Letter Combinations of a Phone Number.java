class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList();
        String[][] map = {{},{},{"a","b","c",""}, {"d","e","f",""}, {"g","h","i",""}, {"j","k","l",""},{"m","n","o",""},{"p","q","r","s"},{"t","u","v",""},{"w","x","y","z"}};
        List<String> res = new ArrayList();
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            List<String> cur = new ArrayList();
            for (String s:res) {
                for (int j = 0; j < 4; j++) {
                    if (map[digits.charAt(i)-'0'][j].length() == 1) 
                        cur.add(s+map[digits.charAt(i)-'0'][j]);
                }
            }
            res = new ArrayList(cur);
        }
        return res;
    }
}