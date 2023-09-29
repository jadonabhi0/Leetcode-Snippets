class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length == 1) return true;
        int n = nums.length-1;
        int c = 0;
        while(nums[c]==nums[c+1]){
            c++;
            if(c==nums.length-1) return true;
        } 
        boolean flag = false;
        if(nums[c] <= nums[c+1]){
            for(int i = c ; i < n ; i++){
                if(nums[i] > nums[i+1]){
                    flag = true;
                }
                if(flag) return false;
            }

        }else{
             for(int i = c ; i < n ; i++){
                if(nums[i] < nums[i+1]){
                    flag = true;
                }
                if(flag) return false;
            }

        }
        return true;
    }
}