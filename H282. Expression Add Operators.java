class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList();
        helper(res, num, target, 0, 0, 0,"");
        return res;
    }
    public void helper(List<String> res, String num, int target, long cur, int pos, long pre, String s) {
        if (pos == num.length() && cur == target) res.add(s);
        for (int i = pos; i < num.length(); i++) {
            if (i > pos && num.charAt(pos) == '0') break;
            long n = Long.parseLong(num.substring(pos, i+1));
            if (pos == 0) {
                helper(res, num, target, n, i+1, n, num.substring(pos,i+1));
            } else {
                helper(res, num, target, cur+n, i+1, n, s+"+"+num.substring(pos, i+1));
                helper(res, num, target, cur-n, i+1, -n, s+"-"+num.substring(pos, i+1));
                helper(res, num, target, cur-pre+pre*n, i+1, pre*n, s+"*"+num.substring(pos, i+1));
            }
        }
    }
}