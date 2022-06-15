class Solution {
    public int integerReplacement(int a) {
        int count = 0;
        long n = a;
        while( n != 1){
            
            if(n % 2 == 0){
                n = n /2;
            }else if( n == 3){
                n = n - 1;
            }
            else if(n % 4 == 3){
                n += 1;
            }else if(n % 4 == 1){
                n -= 1;
            }
            count++;
        }
        
        return count;
    }
}