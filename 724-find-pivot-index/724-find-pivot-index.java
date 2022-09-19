class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0 ; int lsum = 0;
        for(int i : nums) sum += i;
        for(int i = 0 ; i < nums.length ; i++){
            if(sum == 2*lsum + nums[i]) return i;
            lsum += nums[i];
        }
        return -1;
    }
}