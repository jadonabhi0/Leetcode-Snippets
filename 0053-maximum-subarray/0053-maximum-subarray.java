class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){
            if(sum < 0){
                sum = 0;
            }
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);

        }
        return maxSum;
    }

}