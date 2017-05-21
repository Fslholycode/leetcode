public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        if (s.length != pattern.length()) return false;
        Map<Character, List<Integer>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) map.get(c).add(i);
            else {
                map.put(c, new ArrayList<Integer>());
                map.get(c).add(i);
            }
        }
        for (Character ch:map.keySet()) {
            String string = s[map.get(ch).get(0)];
            if (!set.add(string)) return false;
            if (map.get(ch).size() > 1) {
                for (int n:map.get(ch)) {
                    if (!s[n].equals(string)) return false;
                }
            }
        }
        return true;
    }
}