class MedianFinder {
    PriorityQueue<Integer> min = new PriorityQueue(1000, Collections.reverseOrder());
    PriorityQueue<Integer> max = new PriorityQueue();
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (min.size() > max.size()) max.offer(min.poll());
    }
    
    public double findMedian() {
        if (max.size() == min.size()) return (max.peek()+min.peek())/2.0;
        else return max.size() > min.size()? max.peek():min.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */