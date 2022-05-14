class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean[] pre = new boolean[nums.length+1];
        for(int i : nums){
            if(i > 0 && i <= nums.length){
                pre[i] = true;
            }
        }
        
        for(int i = 1 ; i < pre.length ; i++){
            if(pre[i] == false){
                return i;
            }
        }
        return pre.length;
    }
}