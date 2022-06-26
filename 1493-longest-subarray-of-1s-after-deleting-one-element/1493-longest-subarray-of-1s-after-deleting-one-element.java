class Solution {
    public int longestSubarray(int[] nums) {
        int prev = 0;
        int cur = 0;
        int res = 0;
        
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 1)cur++;
            else{
                res = Math.max(res, prev+cur);
                prev = cur;
                cur = 0;
            }
        }
        res = Math.max(res, prev+cur);
        if(res == nums.length) return res - 1;
        return res;
    }
}