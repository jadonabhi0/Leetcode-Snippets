class MedianFinder {

    PriorityQueue<Integer> min = null;
    PriorityQueue<Integer> max = null;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        if(max.isEmpty()) max.offer(num);
        else{
            max.offer(num);
            min.offer(max.poll());
            if(min.size() > max.size()){
                max.offer(min.poll());
            }
        }
        
    }
    
    public double findMedian() {
        if(min.size() == max.size()) return (double) (min.peek() + max.peek()) / 2.0;
        return (double) max.peek();
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */