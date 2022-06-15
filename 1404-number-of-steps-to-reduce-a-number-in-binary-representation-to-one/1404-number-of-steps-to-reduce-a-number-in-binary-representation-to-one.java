class Solution {
    public int numSteps(String s) {
        int ans = 0;
        int count  = 0;
        int carry = 0;
        int  len = s.length()-1;
        
        for(int i = len ; i > 0 ; i--){
            ans  = ans+1;
            if(carry + s.charAt(i)-'0' == 1){
                ans++;
                carry = 1;
            } 
        }
        return ans + carry;
    }
}