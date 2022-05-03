class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        
        // first logic
        
        // PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        // for(int i : nums) q.add(i);
        // int ans = 0;
        // for(int i = 0 ; i < k ; i++) ans = q.poll();
        // return ans;
        
        
        // second logic optimized
        
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i = 0 ; i < k ; i++){
            q.add(nums[i]);
        }
        
        for(int i = k ; i < nums.length ; i++){
            if(q.peek() < nums[i]){
                q.poll();
                q.add(nums[i]);
            }
        }
        return q.peek();
    }
}