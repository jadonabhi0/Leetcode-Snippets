class MedianFinder {

    // maxHeap for left half
    PriorityQueue<Integer> left;
    // minHeap for right half
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> b - a); // max-heap
        right = new PriorityQueue<>();               // min-heap
    }
    
    
    public void addNum(int num) {
       left.offer(num);
       right.offer(left.poll());
       if(right.size() > left.size()){
        left.offer(right.poll());
       }
    }
    
    public double findMedian() {
         if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */