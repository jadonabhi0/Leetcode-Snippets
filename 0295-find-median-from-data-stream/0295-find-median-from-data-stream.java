class MedianFinder {

    ArrayList<Integer> lst;
    public MedianFinder() {
        lst = new ArrayList<>();
    }
    
    public void addNum(int num) {
        int i;
        if(lst.size() == 0) lst.add(num);
        else{
            for(i = 0 ; i < lst.size() && num > lst.get(i) ; i++);
            lst.add(i, num);
        }
        
    }
    
    public double findMedian() {
        int index = lst.size()/2;
        if(lst.size() % 2 == 0){
            return (double) (lst.get(index) + lst.get(index - 1))/2;
        }else{
            return lst.get(index);
        }
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */