class Solution {
    public boolean canJump(int[] nums) {
        int dest = nums.length-1;
        int last = nums.length-2;
        for(int i = last ; i >= 0 ; i--){
            if(i+nums[i] >= dest) dest = i;
        }
        return dest == 0;
    }
}