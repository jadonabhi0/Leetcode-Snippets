class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for(int num : nums) max = Math.max(num, max);
        int ans = 0;
        for(int i = 0 ; i<k ; i++){
            ans += max++;
        }
       return ans;
    }
}