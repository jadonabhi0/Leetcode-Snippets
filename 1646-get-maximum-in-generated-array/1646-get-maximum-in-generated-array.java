class Solution {
    public int getMaximumGenerated(int n) {
        if( n == 0) return 0;
        int[] array = new int[n+1];
        array[0] = 0;
        array[1] = 1;
        for(int i = 2 ; i <= n ; i++){
            array[i] = i % 2 == 0 ? array[i/2] : array[i/2] + array[i/2+1];
        }
        int max = -6546546;
        for(int i : array) max = Math.max(i,max);
        return max;
    }
}