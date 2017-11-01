class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        for (int i=0;i<list1.length;i++) map.put(list1[i], i);
        for (int i=0;i<list2.length;i++) {
            if (map.containsKey(list2[i])) {
                int j = map.get(list2[i]);
                if (j > -1 && i+j <= min) {
                    if (i+j < min) {
                        res.clear();
                        min = i+j;
                    }
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
    
}