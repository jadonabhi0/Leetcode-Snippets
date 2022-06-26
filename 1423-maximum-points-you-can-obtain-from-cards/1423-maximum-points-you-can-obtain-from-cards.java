class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int max = Integer.MIN_VALUE;
        int cur = 0;
        
        for(int i = 0 ; i < k ; i ++){
            cur += cardPoints[i];
        }
        
        max = Math.max(max, cur);
        
        for(int i = k-1 ; i >= 0 ; i--){
            cur += cardPoints[cardPoints.length - k +i];
            cur -= cardPoints[i];
            max = Math.max(max, cur);
        }
        
        
        return max;
    }
}