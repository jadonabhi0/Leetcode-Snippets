class Solution {
    int count(int[] array , int n){
        int c = 0 ;
        for(int i = 0 ; i < array.length ; i++){ 
            if(array[i] == n) c++;
        }
        return c;
    }
    public int singleNumber(int[] nums) {
        int res = 0 ;
        for(int i = 0 ; i < nums.length ;i ++){
            if(count(nums,nums[i]) == 1){
                res = nums[i];
            }
        }
        return res;
    }
}