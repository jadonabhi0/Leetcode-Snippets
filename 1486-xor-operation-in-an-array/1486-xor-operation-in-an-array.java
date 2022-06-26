class Solution {
    public int xorOperation(int n, int start) {
        int [] array = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            array[i] = start + 2 * i;
        }
        
        int xor = array[0];
        
        for(int i = 1 ; i < n ; i++){
            xor ^= array[i];
        }
        
        return xor;
    }
}