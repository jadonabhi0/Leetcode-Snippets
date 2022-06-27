class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxone = 0;
        int cur = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 1) cur++;
            else{
                maxone = Math.max(maxone, cur);
                cur = 0;
            }
        }
        maxone = Math.max(maxone, cur);
        return maxone;
    }
}