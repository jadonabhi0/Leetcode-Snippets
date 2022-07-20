class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int count = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] > nums[i-1]){
                count++;
            }else{
                count = 1;
            }
            max = Math.max(count, max);
        }
        return max == Integer.MIN_VALUE ? 1 : max;
    }
}