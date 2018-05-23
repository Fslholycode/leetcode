class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        helper(s, res, new ArrayList<String>());
        return res;
    }
    
    public void helper(String s, List<List<String>> res, ArrayList<String> list) {
        if (s.length() == 0) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)) {
                list.add(s.substring(0, i+1));
                helper(s.substring(i+1), res, list);
                list.remove(list.size()-1);
            }
        }
        return;
    }
    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;            
        }
        return true;
    } 
}