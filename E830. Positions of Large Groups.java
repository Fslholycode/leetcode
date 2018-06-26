class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList();
        int count = 1;
        char c = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            char cur = S.charAt(i);
            if (c == cur) {
                count++;
            } else {
                if (count >= 3) {
                    List<Integer> list = new ArrayList();
                    list.add(i-count);
                    list.add(i-1);
                    res.add(list);
                }
                count = 1;
                c = cur;
            }
        }
        if (count >= 3) {
            List<Integer> list = new ArrayList();
            list.add(S.length()-count);
            list.add(S.length()-1);
            res.add(list);
        }
        return res;
    }
}