class Solution {
    public int[] sortArray(int[] nums) {
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : nums){
            pq.add(i);
        }
        
       
        int c = pq.size();
        
        for(int i = 0 ; i < c ; i++){
            nums[i] = pq.poll();
        }
        
        return nums;
    }
}