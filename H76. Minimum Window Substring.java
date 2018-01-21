class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int time = map.getOrDefault(c, 0);
            map.put(c,time+1);
        }
        String res = "";
        int left = 0, minLeft=0, minLen =s.length()+1, count = 0;
        for (int right = 0; right < s.length(); right++) {
            char r = s.charAt(right);
            if (map.containsKey(r)) {
                map.put(r, map.get(r)-1);
                if(map.get(r)>=0) count++;
            }
            while (count == t.length()) {
                if(right-left+1 < minLen){
                    minLeft = left;
                    minLen = right-left+1;
                }
                char l = s.charAt(left);
                if (map.containsKey(l)) {
                    map.put(l, map.get(l)+1);
                    if(map.get(l)>0) count--;
                }
                left++;
            }
        }
        return minLen==s.length()+1?"":s.substring(minLeft, minLeft+minLen);
    }
}