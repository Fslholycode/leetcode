public class Solution {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = 10 * count + (s.charAt(i) - '0');
                    i++;
                }
                s1.push(count);
            }
            else if (s.charAt(i) == '[') {
                s2.push(res);
                res = "";
                i++;
            }
            else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder(s2.pop());
                int time = s1.pop();
                while (time-- > 0) {
                    sb.append(res);
                }
                res = sb.toString();
                i++;
            } else {
                res += s.charAt(i++);
            }
        }
        return res;
    } 
}