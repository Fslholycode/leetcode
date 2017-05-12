public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
            max = Math.max(max, map.get(c));
        }
        List<Character> [] bucket = new List[max + 1];
        for (char c:map.keySet()) {
            int frequence = map.get(c);
            if (bucket[frequence] == null) bucket[frequence] = new ArrayList<>();
            bucket[frequence].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length-1; i >= 0; i--) {
            if (bucket[i] == null) continue;
            for (char c : bucket[i]) {
                int index = i;
                while (index > 0) {
                    index--;
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}