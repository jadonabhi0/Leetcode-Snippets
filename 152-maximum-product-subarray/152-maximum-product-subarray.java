class Solution {
    public int maxProduct(int[] nums) {
        
        // using kadan's algo
        
        int maxp = Integer.MIN_VALUE;
        int pro = 1;
        
        
        
        for(int i = 0 ; i < nums.length ; i++){
            
            pro = pro*nums[i];
            
            maxp = Math.max(pro, maxp);
            
            
            if(pro == 0){
                pro = 1;
            }
        }
        
        pro = 1;
        
        for(int i = nums.length-1 ; i >= 0 ; i--){
            pro *= nums[i];
            
            maxp = Math.max(maxp,pro);
           
            if(pro == 0){
                pro = 1;
            }
        }
         return maxp;
    }
}