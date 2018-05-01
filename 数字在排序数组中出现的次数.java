public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if (array.length == 0) return 0;
        if (k < array[0] || k > array[array.length-1]) return 0;
        int first=getFirstK(array,k,0,array.length-1);
        int last=getLastK(array,k,0,array.length-1);
        if(first==-1 ||last==-1){
            return 0;
        }
        return last-first+1;
    }
    public int getFirstK(int[] array, int k, int start, int end) {
        while (start <= end) {
            int mid = start+(end-start)/2;
            if (array[mid] > k) {
                end = mid-1;
            } else if (array[mid] < k) {
                start = mid+1;
            } else {
                if (mid == 0 || array[mid-1] != k) return mid;
                else end = mid-1;
            }
        }
        return -1;
    }
    public int getLastK(int[] array, int k, int start, int end) {
        while (start <= end) {
            int mid = start+(end-start)/2;
            if (array[mid] > k) {
                end = mid-1;
            } else if (array[mid] < k) {
                start = mid+1;
            } else {
                if (mid == array.length-1 || array[mid+1] != k) return mid;
                else start = mid+1;
            }
        }
        return -1;
    }
}