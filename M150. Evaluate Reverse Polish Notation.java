class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack();
        for (String str : tokens) {
            if (Character.isDigit(str.charAt(0)) || str.length() > 1) s.push(Integer.parseInt(str));
            else {
                int num2 = s.pop();
                int num1 = s.pop();
                if (str.equals("+")) s.push(num1+num2);
                if (str.equals("-")) s.push(num1-num2);
                if (str.equals("/")) s.push(num1/num2);
                if (str.equals("*")) s.push(num1*num2);
            }
        }
        return s.pop();
    }
}