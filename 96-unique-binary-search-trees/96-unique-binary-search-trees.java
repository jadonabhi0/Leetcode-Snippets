class Solution {
    public int numTrees(int n) {
        int[] array = new int[n+1];
        
        array[0] = 1;
        array[1] = 1;
        
        for(int i = 2 ; i <= n ; i++){
            int l = 0;
            int r = i-1;
            
            while(l <= i-1){
                
                array[i] += array[l]*array[r];
                l++;
                r--;
                
            }
        }
        return array[n];
    }
}