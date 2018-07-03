class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i <= num.length()/2; i++) {
            if (num.charAt(0) == '0' && i >= 2) continue;
            for (int j = i+1; num.length()-j >= j-i; j++) {
                if (num.charAt(i) == '0' && j-i>=2) continue;
                long num1 = Long.parseLong(num.substring(0, i));
                long num2 = Long.parseLong(num.substring(i, j));
                String left = num.substring(j);
                if (isAdditive(left, num1, num2)) return true;
            }
        }
        return false;
    }
    public boolean isAdditive(String num, long num1, long num2) {
        if (num.length() == 0) return true;
        long sum = num1+num2;
        String s = Long.toString(sum);
        if (!num.startsWith(s)) return false;
        return isAdditive(num.substring(s.length()), num2, sum);
    }
}