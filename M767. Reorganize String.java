class Solution {
    public String reorganizeString(String S) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[1]-a[1];
            }
        });
        int[] arr = new int[26];
        for (char c : S.toCharArray()) {
            arr[c-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                int[] s = new int[2];
                s[0] = i;
                s[1] = arr[i];
                pq.offer(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        int[] prev = new int[2];
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length()-1)-'a') {
                sb.append((char)(first[0]+'a'));
                if (--first[1] > 0) pq.offer(first);
            } else {
                int[] second = pq.poll();
                if (second == null) return "";
                sb.append((char)(second[0]+'a'));
                if (--second[1] > 0) pq.offer(second);
                pq.offer(first);
            }
        }
        return sb.toString();
    }
}