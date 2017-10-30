class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 1) {
                i = i+1;
                if (i == bits.length-1) return false;
                continue;
            }
        }
        return true;
    }
}