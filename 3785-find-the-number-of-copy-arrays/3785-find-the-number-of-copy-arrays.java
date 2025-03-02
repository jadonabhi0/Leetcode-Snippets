class Solution {
    public int countArrays(int[] original, int[][] bounds) {
        int lo = bounds[0][0], hi = bounds[0][1];
        int ans = hi-lo+1;

        for(int i = 1 ; i < original.length ; i++){

            int diff = original[i] - original[i-1];

            lo = Math.max(lo+diff, bounds[i][0]);
            hi = Math.min(hi+diff, bounds[i][1]);
            ans = Math.min(ans, hi - lo + 1);
            
        }
        return ans < 0 ? 0 : ans;

    }
}