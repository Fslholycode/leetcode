public class Solution {
    public int NumberOf1(int n) {
        int flag  = 1;
        int count = 0;
        while (flag != 0) {
            if ((flag & n) != 0) count++; 
            flag = flag<<1;
        }
        return count;
    }
}
//
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n&(n-1);
        }
        return count;
    }
}