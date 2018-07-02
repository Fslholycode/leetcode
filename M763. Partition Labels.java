class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList();
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        int cur = 0;
        while (cur < S.length()) {
            int max = cur;
            int index = cur;
            while (index <= max) {
                max = Math.max(max, map.get(S.charAt(index)));
                index++;
            }
            res.add(max-cur+1);
            cur = max+1;
        }
        return res;
    }
}