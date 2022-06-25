class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        
        int cur = 1; //
        int max = 1;
        
        Arrays.sort(nums);
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i-1] == nums[i]) continue;
            if(nums[i-1]+1 == nums[i]){
                cur += 1;
            }
            else{
                max = Math.max(max,cur);
                cur = 1;
            }
        }
        return Math.max(max,cur);
    }
}