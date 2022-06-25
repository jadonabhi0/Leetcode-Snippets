class Solution {
    public boolean checkPossibility(int[] nums) {
        
        int count = 0;
        
        for(int i = 1 ; i < nums.length ; i++){
            
            if(nums[i-1] > nums[i]){ // checking previous element is greater or not
                
                count ++;
                
                if(count > 1){  // if event has happend more than one time.
                    return false;
                }
                
                if(i < 2 || nums[i-2] <= nums[i]) // if second previous is less than current
                {
                    nums[i-1] = nums[i];
                }
                else{
                    nums[i] = nums[i-1];
                }
            }
            
        }
        
        return true;
    }
}