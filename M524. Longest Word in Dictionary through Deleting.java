class Solution {
    public String findLongestWord(String s, List<String> d) {
        if (s.length() == 0 || d.size() == 0) return "";
        String res = "";
        Collections.sort(d, (a,b) -> {
            if (a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });
        for (int i = 0; i < d.size(); i++) {
            if (isSubSeq(s,d.get(i))) return d.get(i);
        }
        return res;
    }
    private boolean isSubSeq(String s, String p) {
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if (s.charAt(i) == p.charAt(j)) {
                i++; j++;
            }
            else {
                i++;
            }
        }
        return j == p.length();
    }
}