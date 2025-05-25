class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        int n = grid.length * grid.length;

        long sn = (n * (n+1))/2;
        long s2n = (n * (n + 1) * (2L*n + 1)) / 6;

        long s  = 0;
        long s2  = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid.length ; j++){
                s += (long)grid[i][j];
                s2 +=  (long)grid[i][j] * (long)grid[i][j];
            }
        }

        long val1 = sn - s;
        long val2 = s2n - s2;

        val2 = val2/val1;

        long x = (val1 + val2)/2;
        long y = val2 - x;

        return new int[]{(int)y, (int)x};

    }
}