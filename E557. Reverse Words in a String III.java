class Solution {
    public String reverseWords(String s) {
        String[] res = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(reverse(res[i])+" ");
            
        }
        String r = sb.toString();
        return r.substring(0, r.length()-1);
    }
    public String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}