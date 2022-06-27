class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxone = 0;
        int i = 0;
        int zc = 0;
        for(int j = 0 ; j < nums.length ; j++){
            
            if(nums[j] == 0) zc++; // this condition match up the window size;
            
            //============== This snippet work as to reset the window =========
            while(zc > k){ 
                if(nums[i++] == 0) zc--;
            }
            maxone = Math.max(maxone, j - i + 1);
            //=================================================================
        }
        return maxone;
    }
}