class Solution {
    
    HashMap<String, Boolean> map = new HashMap();
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if(sum < desiredTotal) return false;
        if(desiredTotal <= 0) return true;
        
        HashMap<String, Boolean> map = new HashMap();
        int[] used = new int[maxChoosableInteger+1];
        return helper(desiredTotal, map, used);
    }
    public boolean helper(int desiredTotal, HashMap<String, Boolean> map, int[] used) {
        String s = Arrays.toString(used);
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (desiredTotal <= 0) {
            map.put(s, false);
            return false;
        }
        for (int i = 1; i < used.length; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                if (!helper(desiredTotal-i, map, used)) {
                    map.put(s, true);
                    used[i] = 0;
                    return true;
                }
                used[i] = 0;
            }
        }
        map.put(s, false);
        return false;
    }
}