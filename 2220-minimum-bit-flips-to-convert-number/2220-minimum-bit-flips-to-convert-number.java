class Solution {
    public int minBitFlips(int start, int goal) {
        int ans = 0;
        
        for(int i = 0 ; i < 32 ; i++){
            boolean si = false;
            boolean gi = false;
            
            if((start & (1 << i)) > 0) si = true;
            if((goal & (1 << i)) > 0) gi = true;
            
            if(gi && !si) ans++;
            else if(!gi && si) ans++;
        }
        
        return ans++;
    }
}