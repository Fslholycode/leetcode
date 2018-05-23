class MyCalendarTwo {
    List<int[]> books = new ArrayList(); 
    public MyCalendarTwo() {
    }
    
    public boolean book(int start, int end) {
        MyCalendar overlap = new MyCalendar();
        for (int[] b:books) {
            if (Math.max(b[0],start) < Math.min(b[1],end)) {
                if (!overlap.book(Math.max(b[0],start), Math.min(b[1],end))) return false;
            }
        }
        books.add(new int[] {start ,end});
        return true;
    }
    private static class MyCalendar {
        List<int[]> books = new ArrayList();
        public boolean book (int start, int end) {
            for (int[] b : books) {
                if (Math.max(b[0],start) < Math.min(b[1], end)) return false;
            }
            books.add(new int[]{start, end});
            return true;
        }
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */