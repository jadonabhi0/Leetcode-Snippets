class Solution {
    public int findMiddleIndex(int[] nums) {
        int sum = 0;
        
        for(int val : nums){
            sum += val;
        }
        
        int lsum = 0;
        
        for(int i = 0 ; i < nums.length ; i++){
            if(lsum == sum - lsum - nums[i]) return i;
            lsum += nums[i];
        }
        return -1;
    }
}