public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        int jmask = 0;
        int j = 0;
        
        for(int i = 31 ; i>=0 ; i--){
            if(((1 << i) & n) == 0){
                j++;
            }else{
                jmask |= (1 << j);
                j++;
            }
        }
        return jmask;
    }
}