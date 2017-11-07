class Solution {
    public String originalDigits(String s) {
        if (s.length() == 0) return "";
        int[] map = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'z') map[0]++;
            if (c == 'w') map[2]++;
            if (c == 'x') map[6]++;
            if (c == 's') map[7]++;//7-6
            if (c == 'g') map[8]++;
            if (c == 'h') map[3]++;//3-8
            if (c == 'v') map[5]++;//5-7
            if (c == 'u') map[4]++;
            if (c == 'o') map[1]++;//1-0-2-4
            if (c == 'i') map[9]++;//9-5-6-8
        }
        map[7] -= map[6];
        map[3] -= map[8];
        map[5] -= map[7];
        map[1] -= map[0]+map[2]+map[4];
        map[9] -= map[5]+map[6]+map[8];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int num = map[i];
            while (num > 0) {
                sb.append(i);
                num--;
            }
        }
        return sb.toString();
    }
}