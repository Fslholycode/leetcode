class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1]-b[1];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int time = 0;
        for (int[] course:courses) {
            time+=course[0];
            pq.add(course[0]);
            if (time > course[1]) {
                time -= pq.poll();
            }
        }
        return pq.size();
    }
}