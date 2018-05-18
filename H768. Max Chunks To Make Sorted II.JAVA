class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] leftmax = new int[arr.length];
        int[] rightmin = new int[arr.length];
        int count = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            leftmax[i] = max;
        } 
        int min = Integer.MAX_VALUE;
        for (int i = arr.length-1; i >= 0; i--) {
            min = Math.min(min, arr[i]);
            rightmin[i] = min;
        }
        for (int i = 0; i < arr.length-1; i++) {
            if (leftmax[i] <= rightmin[i+1]) count++;
        }
        return count;
    }
}