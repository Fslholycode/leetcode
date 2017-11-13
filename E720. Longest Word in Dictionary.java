class Solution {
    public String longestWord(String[] words) {
        int max = 0;
        String res = "";
        Set<String> set = new HashSet<String>();
        for (String s : words) {
            set.add(s);
        }
        for (String s :words) {
            int i;
            for (i = 1; i < s.length(); i++) {
                if (!set.contains(s.substring(0,i))) 
                    break;
            }
            if (i == s.length()) {
                if (s.length() > max) {
                    max = s.length();
                    res = s;
                } 
                if (s.length() == max) {
                    res = (s.compareTo(res) > 0? res:s);
                }
            } 
        }
        return res;
    }
}