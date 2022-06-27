class Solution {
    public int maxPower(String s) {
        int cur = 1;
        int max = 0;
        
        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                cur++;
            }else{
                max = Math.max(cur,max);
                cur = 1;
            }
        }
        max = Math.max(cur,max);
        return max;
    }
}