class Solution {
    public boolean checkValidString(String s) {
        return checkFromLeft(s) && checkFromRight(s);
    }
    public boolean checkFromLeft(String s) {
        int open = 0;
        int close = 0;
        int star = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') star++;
            if (s.charAt(i) == '(') open++;
            if (s.charAt(i) == ')') close++;
            if (close > open + star) {
                return false;
            }
        }
        if (close == open || close - open <= star) {
            return true;
        }
        return false;
    }
    public boolean checkFromRight(String s) {
        int open = 0;
        int close = 0;
        int star = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '*') star++;
            if (s.charAt(i) == ')') open++;
            if (s.charAt(i) == '(') close++;
            if (close > open + star) {
                return false;
            }
        }
        if (close == open || close - open <= star) {
            return true;
        }
        return false;
    }
}
