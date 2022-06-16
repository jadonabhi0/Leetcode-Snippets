class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        
        for(int i = 0 ; i < 32 ; i++){
            
            boolean ai = false;
            boolean bi = false;
            boolean ci = false;
            
            // checking the ith bit a || b || c
            if((a & (1 << i)) > 0) ai = true;
            if((b & (1 << i)) > 0) bi = true;            
            if((c & (1 << i)) > 0) ci = true;
            
            // ci is set
            if(ci){
                 if(!ai && !bi) ans++;
                
            }else{
                
                if(ai && bi) ans += 2; // if ai && bi both set and ci is unset;
                else if(ai || bi) ans++;
            }
        }
        return ans;
    }
}