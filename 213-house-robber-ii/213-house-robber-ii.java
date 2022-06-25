class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)    return nums[0];
        if(n == 2)    return Math.max(nums[0], nums[1]);
     
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        // include ist house ans excluding the last house
        
        dp1[0] = nums[0];
        dp1[1] = Math.max(dp1[0],nums[1]);
        
        for(int i = 2 ; i < n-1 ; i++){
            dp1[i] = Math.max((nums[i]+dp1[i-2]),dp1[i-1]);
        }
        
        // exclude ist house and including last house
        dp2[0] = 0;
        dp2[1] = nums[1];
        
        for(int i = 2 ; i < n ; i++){
             dp2[i] = Math.max((nums[i]+dp2[i-2]),dp2[i-1]);
        }
        
        // System.out.println(Arrays.toString(dp1));
        // System.out.println(Arrays.toString(dp2));
        return Math.max(dp1[n-2], dp2[n-1]);
    }
}