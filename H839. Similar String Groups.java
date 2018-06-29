class Solution {
    public int numSimilarGroups(String[] A) {
        boolean[] visited = new boolean[A.length];
        Queue<String> q = new LinkedList();
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (visited[i]) continue;
            q.offer(A[i]);
            visited[i] = true;
            res++;
            while (!q.isEmpty()) {
                String cur = q.poll();
                for (int j = 0; j < A.length; j++) {
                    if (visited[j]) continue;
                    if (isSimilar(cur, A[j])) {
                        q.offer(A[j]);
                        visited[j] = true;
                    }
                }
            }
        }
        return res;
    }
    public boolean isSimilar(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) count++;
        }
        return count == a.length()-2 || count == a.length();
    }
}