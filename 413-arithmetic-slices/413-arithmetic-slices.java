class Solution {
    public int numberOfArithmeticSlices(int[] array) {
        if(array.length < 3) return 0;
        int [] dp = new int[array.length];
        int ans = 0 ;
        for(int i = 2 ; i < dp.length ; i ++){
            if(array[i]-array[i-1] == array[i-1] - array[i-2]){
                dp[i] = dp[i-1] + 1;
                ans += dp[i];
            }
        }
        return ans;
    }
}