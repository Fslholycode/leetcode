public class Solution {
    public String getHint(String secret, String guess) {
        int[] nums1 = new int[10];
        int[] nums2 = new int[10];
        int bull = 0, cow = 0;
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            char g = guess.charAt(i);
            if (c == g) bull++;
            else {
                nums1[c-'0']++;
                nums2[g-'0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cow += Math.min(nums1[i],nums2[i]);
        }
        return bull+"A"+cow+"B";
    }
}