class Solution {
    public int[] singleNumber(int[] nums) {
        
        int xor = 0;
        for(int val : nums){
            xor ^= val;
        }
        
        int rmsb = xor & -xor;
        
        int x = 0;
        int y = 0;
        for(int val : nums){
            if((rmsb & val) == 0){
                x ^= val;
            }else{
                y ^= val;
            }
        }
        
        int[] array = {x,y};
        return array;
    }
}