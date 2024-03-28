class Solution {
    
    public boolean isPowerOfFour(int n) {
        
        int mask = 0b01010101010101010101010101010101;
        return n > 0 && (n & (n-1)) == 0 && (mask & n) > 0;   
        
    }
}
