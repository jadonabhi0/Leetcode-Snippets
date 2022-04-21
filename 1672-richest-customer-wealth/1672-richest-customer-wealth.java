class Solution {
    public int maximumWealth(int[][] acc) {
        int max = 0;
        int sum = 0;
        for(int i = 0 ; i < acc.length ; i++){
            for(int j = 0 ; j < acc[i].length ; j++){
                sum += acc[i][j];
            }
            max = Math.max(sum,max);
            sum = 0 ;
        }
        return max;
    }
}