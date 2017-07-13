public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        char[] C = new char[26];
        int i;
        C[0] = 'A'; C[1]='B'; C[2] = 'C'; C[3] = 'D'; C[4] = 'E'; C[5] = 'F'; C[6] = 'G'; C[7] = 'H'; C[8] = 'I'; C[9] = 'J';
        C[10] = 'K'; C[11] = 'L'; C[12] = 'M'; C[13]='N'; C[14] = 'O'; C[15] = 'P'; C[16] = 'Q'; C[17] = 'R'; C[18]= 'S';
        C[19] = 'T'; C[20] = 'U'; C[21] = 'V'; C[22] = 'W'; C[23] = 'X'; C[24] = 'Y'; C[25] = 'Z';
        while (n != 0) {
            n--;
            i = n%26;
            n /= 26;
            sb.append(C[i]);
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
    		System.out.println(new Solution().convertToTitle(52));
    }
}