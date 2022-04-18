class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x == 0) return true;
        int c = 0 ;
        int temp = x;
        while( x != 0){
            int a = x%10;
            x = x/10;
            c = c*10+a;
        }
        return temp == c;
    }
}