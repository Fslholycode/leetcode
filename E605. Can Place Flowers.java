class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int dis = 1;
        int res = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                res+=(dis-1)/2;
                dis = 0;
            } else {
                dis++;
            }
        }
        if(dis != 0) res += dis/2;
        return n <= res;
    }
}