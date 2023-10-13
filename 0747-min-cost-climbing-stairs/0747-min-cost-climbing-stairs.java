class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a = cost[0];
        int b = cost[1];
        
        for(int i = 2 ; i < cost.length ; i++){
            int c = Math.min(a,b)+ cost[i];
            a = b ; b = c;
        }

        return Math.min(a,b);
    }
}