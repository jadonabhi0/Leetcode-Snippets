class Solution {
    public int binaryGap(int n) {
        int[] array = new int[32];
        int max = Integer.MIN_VALUE;
        int t = 0;
        
        for(int i = 0 ; i < 32 ; i++){
            if(((n >> i) & 1) != 0){
                array[t++] = i;
            }
        }
        
        
        for(int i = 1 ; i < 32 ; i++){
            max = Math.max(max,(array[i] - array[i-1]));
        }
        
        return max;
    }
}