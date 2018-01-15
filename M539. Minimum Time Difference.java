class Solution {
    public int findMinDifference(List<String> timePoints) {
        int min = Integer.MAX_VALUE;
        int[] time = new int[timePoints.size()];
        int index = 0;
        for (String string : timePoints) {
            int hour = Integer.parseInt(string.substring(0,2));
            int minu = 60*hour+Integer.parseInt(string.substring(3));
            time[index++] = minu;
        }
        Arrays.sort(time);
        for (int i = 0 ; i < time.length-1; i++) {
            min = Math.min(min, time[i+1]-time[i]);
        }
        min = Math.min(min, 1440+time[0]-time[time.length-1]);
        return min;
    }
}