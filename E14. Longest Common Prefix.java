class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        for (int i = 1; i <= strs[0].length(); i++) {
            String s = strs[0].substring(0,i);
            for (int j = 1 ; j < strs.length; j++) {
                if (strs[j].length() < i || !s.equals(strs[j].substring(0,i))) {
                    if (i == 1) return "";
                    else return strs[0].substring(0,i-1);
                }
            }
        }
        return strs[0].substring(0);
    }
}