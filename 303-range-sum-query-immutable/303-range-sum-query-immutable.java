class NumArray {

    int[] dp ;
    public NumArray(int[] nums) {
        int len = nums.length;
        dp = new int[len];
        for(int i = 0 ; i < len ; i++){
           if(i == 0){
                dp[i] = nums[i];
           }else{
                dp[i] = nums[i] + dp[i-1];
           }
        }
    }
    
    public int sumRange(int left, int right) {
        if( left == 0) return dp[right];
        return dp[right] - dp[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */