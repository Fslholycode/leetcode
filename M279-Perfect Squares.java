public class Solution {
    public int numSquares(int n) {
        int[] state = new int[n+1];
        state[0] = 0;
        state[1] = 1;
        for (int i = 2; i < n+1; i++) {
            int j = maxIndex(i);
            //System.out.println(j);
            state[i] = state[i-j*j] + 1;
            j--;
	        	while (j >= 1) {
	        	    state[i] = Math.min(state[i], state[i-j*j] + 1);
	        	    j--;
	        	}
        }
        return state[n];
    }
    
    public int maxIndex(int n) {
        for (int i = 1; i <= n ; i++) {
            if (n < i*i) {
                return i-1;
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
    	    System.out.println(new Solution().numSquares(48));
    }
}