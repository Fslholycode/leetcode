class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[k];
        for (int i = Math.max(0, k-len2); i <= len1 && i <= k; i++) {
            int[] maxMerge = merge(maxArr(nums1, i), maxArr(nums2, k-i), k);
            if (greater(maxMerge, 0, res, 0)) res = maxMerge;
        }
        return res;
    }
    public int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int index = 0, i = 0, j = 0;
        for (; index < k; index++) {
            res[index] = greater(nums1, i, nums2, j)? nums1[i++] : nums2[j++];
        }
        return res;
    }
    
    public int[] maxArr(int[] nums, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0; i < nums.length; i++) {
            while (j > 0 && nums[i] > res[j-1] && nums.length-i+j>k) j--;
            if (j < k) res[j++] = nums[i];
        }
        return res;
    }
    
    public boolean greater(int[] maxMerge, int i, int[] res, int j) {
        while (i < maxMerge.length && j < res.length && maxMerge[i] == res[j]) {
            i++;
            j++;
        }
        return j == res.length || (i < maxMerge.length && maxMerge[i] > res[j]);
    }
}