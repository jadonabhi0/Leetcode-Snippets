class Solution {
    public int minMoves2(int[] nums) {
        
        Arrays.sort(nums);
        
        int n = nums.length;
        
        if(n == 1) return 0;
        int median = n/2 == 0 ? (nums[n/2]+nums[n/2 - 1] / 2) : nums[n/2];
        
        int count = 0;
        
        for(int i = 0 ; i < nums.length ; i++){
            count += Math.abs(nums[i]-median);
        }
        
        return count;
    }
}