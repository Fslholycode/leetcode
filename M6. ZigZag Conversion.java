class Solution {
    public String convert(String s, int numRows) {
        if (s.length() <= 1 || numRows <= 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        for (int i = 0; i < s.length(); i++) {
            int index = i%(2*numRows-2);
            index = (index > numRows-1? (2*numRows-2-index):index);
            sb[index].append(s.charAt(i));
        }
        String res = "";
        for (int i = 0; i < numRows; i++) {
            res += sb[i].toString();
        }
        return res;
    }
}