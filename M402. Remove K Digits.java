import java.util.Stack;

public class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        Stack<Integer> s = new Stack<Integer>();
        int dig = num.charAt(0) - 48;
        s.push(dig);
        for (int i = 1; i < num.length(); i++) {
            dig = num.charAt(i) - 48;
            while (k > 0 && !s.empty() && dig < s.peek()) {
                s.pop();
                k--;
            }
            s.push(dig);
        }
        while (k > 0) {
            k--;
            s.pop();
        }
        String result = "";
        while (!s.empty()) {
            result = String.valueOf(s.pop()) + result; 
        }
        while (result.indexOf("0") == 0 && result.length() > 1) {
            result = result.substring(1);
        }
        return result;
    }
    public static void main(String[] args) {
    	    System.out.println(new Solution().removeKdigits("1432219",3));
    }
}