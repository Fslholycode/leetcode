class Solution {
    public int findKthNumber(int m, int n, int k) {
        int start = 1;
        int end = m*n;
        while (start < end) {
            // System.out.println(start+" "+end);
            int mid = start+(end-start)/2;
            int sum = 0;
            // boolean isDivided = false;
            for (int i = 1; i <= m; i++) {
                sum += Math.min(n,mid/i);
                // if (mid%i == 0) isDivided = true;
            } 
            if (sum < k) start = mid+1;
            else end = mid;
        }
        return start;
    }
}