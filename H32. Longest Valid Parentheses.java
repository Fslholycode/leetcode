public class Solution {
    public int longestValidParentheses(String s) {
        int length = 0, left = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                if (stack.isEmpty()) left = i;
                else {
                    stack.pop();
                    if (stack.isEmpty()) length = Math.max(length, i-left+1);
                    else length = Math.max(length, i-stack.peek()+1);
                }
            }
        }
        return length;
    }
}