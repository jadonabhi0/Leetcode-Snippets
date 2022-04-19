class Solution {
    public int findMin(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i : nums){
            q.add(i);
        }
        return q.poll();
    }
}