class Solution {
    public int minMoves(int[] nums) {
        int ele = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(ele > nums[i]){
                ele = nums[i];
            }
            sum += nums[i];
        }
        return sum - nums.length*ele;   
    }
}