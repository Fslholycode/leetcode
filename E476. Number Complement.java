class Solution {
    public int findComplement(int num) {
        int i = 31;
        int m = 0;
        while (i > 0) {
        	    m += 1<<i;
            if ((m & num) != 0) break;
            i--;
        }
        i = 32-i-2;
        int mask = Integer.MAX_VALUE >>i;
        return num^mask;
    }

}