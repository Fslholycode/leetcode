class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] num = new int[l1+l2];
        for (int i = 0; i < l1; i++) {
            num[i] = nums1[i];
        }
        for (int i = 0; i < l2; i++) {
            num[i+l1] = nums2[i];
        }
        Arrays.sort(num);
        return num.length%2 == 0? (num[(l1+l2)/2-1]+num[(l1+l2)/2])/2.0:num[(l1+l2)/2];
    }
}