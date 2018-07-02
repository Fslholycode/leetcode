class Solution {
    public int compress(char[] chars) {
        int cur = 0;
        int res = 0;
        for (int i= 0; i < chars.length; i++) {
            cur++;
            if (i == chars.length-1 || chars[i] != chars[i+1]) {
                chars[res++] = chars[i];
                if (cur != 1) {
                    char[] arr = String.valueOf(cur).toCharArray();
                    for(int j=0;j<arr.length;j++) {
                        chars[res++] = arr[j];
                    }
                }
                cur = 0;
            }
        }
        return res;
    }
}