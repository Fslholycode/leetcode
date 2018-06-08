class MyCalendar {
    List<int[]> map = new ArrayList();
    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        for (int[] item:map) {
            if (Math.max(item[0], start) < Math.min(end, item[1])) {
                return false;
            } 
        }
        map.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */