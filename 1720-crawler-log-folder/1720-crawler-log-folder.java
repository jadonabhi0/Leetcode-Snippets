class Solution {
    public int minOperations(String[] logs) {
        int ans = 0 ; 

        for(String s : logs){
            if((ans == 0 && s.equals("../")) || s.equals("./")) continue;
            else {
                if(s.equals("../") && ans > 0) ans--;
                else ans++;
            }
        }
        return ans;
    }
}