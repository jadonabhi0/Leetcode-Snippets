class Solution {
    public int maxSubArray(int[] nums) {
        
        
        // usinf Kadane's algo
        
        int cursum = 0;
        int sum = Integer.MIN_VALUE;;
        
        for(int i = 0 ; i < nums.length ; i++){
             
            cursum += nums[i];
            
            sum = Math.max(cursum, sum);
            
            if(cursum < 0){
                cursum = 0;
            } 
            
        }
        return sum;
    }
}