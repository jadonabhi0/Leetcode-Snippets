class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length+1;
        
        int sum1 = 0;
        
        for(int i = 0 ;i <= n-1 ; i++){
            sum1+=i;
        }
        
        int sum2 = 0;
        
        for(int i = 0 ; i < n-1 ; i++){
            sum2 += nums[i];
        }
        
        return sum1 - sum2;
    }
}