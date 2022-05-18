class Solution {
    public int timeRequiredToBuy(int[] ti, int k) {
       
        int ans = 0;
        
        for(int i = 0 ; i < ti.length ; i++){
            if(i <= k){
                ans += Math.min(ti[k], ti[i]);
            }else{
                ans += Math.min(ti[k] -1 , ti[i]);
            }
        }
        return ans;
    }
}