class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i : nums) q.add(i);
        int ans = 0;
        for(int i = 0 ; i < k ; i++) 
            ans = q.poll();
        return ans;
    }
}