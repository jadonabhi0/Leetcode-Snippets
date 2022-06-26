class Solution {
    public int minimumDeletions(int[] nums) {
        if(nums.length == 1) return 1;
        
        int minidx = 0, min = Integer.MAX_VALUE;
        int maxidx = 0, max = Integer.MIN_VALUE;
        
        
        for(int i = 0 ; i < nums.length ; i++){
            
            if(min>nums[i]){
                min = nums[i];
                minidx = i;
            }
            
            if(max<nums[i]){
                max = nums[i];
                maxidx = i;
            }
            
        }
        
       
        
        int n=nums.length;
        int b=Math.max(maxidx,minidx);
        int s=Math.min(maxidx,minidx);
        return Math.min(s+1+n-b,Math.min(b+1,n-s));
    }
}