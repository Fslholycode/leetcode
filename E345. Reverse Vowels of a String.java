class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length()==0) return s;
        String vowels = "aeiouAEIOU";
        int right = s.length()-1;
        int left = 0;
        char[] chars = s.toCharArray();
        while (left < right) {
            while (left < right && !vowels.contains(chars[left]+"")) left++;
            while (right > left && !vowels.contains(chars[right]+"")) right--;
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}