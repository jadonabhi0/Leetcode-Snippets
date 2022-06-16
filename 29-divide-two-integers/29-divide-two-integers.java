class Solution {
//     public int divide(int dividend, int divisor) {
//         if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
       

//         int sign = dividend > 0 && divisor > 0 ? -1 : 1;
//         long num = Math.abs(dividend);
//         long deno = Math.abs(divisor);
//         int ans = 0;

//         while(deno <= num){

//             long temp = deno ; int count = 1;
//             while((temp << 1) <= num){
//                 temp = temp << 1;
//                 count = count << 1;
//             }
//             ans += count;
//             num = num - temp;
//         }
//         return sign * ans;
//     }
    
    
    
    
    public int divide(int dividend, int divisor) {
    if(dividend == Integer.MIN_VALUE && divisor == -1){
        return Integer.MAX_VALUE;
    }
    return dividend / divisor;
}
}