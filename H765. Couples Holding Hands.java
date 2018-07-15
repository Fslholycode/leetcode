class Solution {
    public int minSwapsCouples(int[] row) {
        Map<Integer, Integer> map = new HashMap();
        int index = 0;
        while (index<row.length) {
            map.put(row[index], row[index+1]);
            map.put(row[index+1], row[index]);
            index+=2;
        }
        index = 0;
        int res = 0;
        while (index < row.length) {
            if (map.get(index) != index+1) {
                int cur = map.get(index);
                int other = map.get(index+1);
                map.put(index, index+1);
                map.put(cur, other);
                map.put(other, cur);
                res++;
            }
            index+=2;
        }
        return res;
    }
}