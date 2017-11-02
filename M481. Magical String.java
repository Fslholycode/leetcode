class Solution {
    public int magicalString(int n) {
        StringBuilder magic = new StringBuilder("1221121221221121122");
        int pt1 = 12, pt2 = magic.length()-1, count = 0;
        while (magic.length() < n) {
            if (magic.charAt(pt1) == '1') {
                if (magic.charAt(pt2) == '1') magic.append(2);
                else magic.append(1);
                pt2++;
            } else {
                if (magic.charAt(pt2) == '1') magic.append(22);
                else magic.append(11);
                pt2+=2;
            }
            pt1++;
        }
        for (int i = 0; i < n; i++) {
            if (magic.charAt(i) == '1') count++;
        }
        return count;
    }
}