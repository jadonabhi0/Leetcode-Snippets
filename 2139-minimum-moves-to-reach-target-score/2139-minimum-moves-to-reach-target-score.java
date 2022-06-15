class Solution {
    public int minMoves(int target, int maxDoubles) {
        long x = target;
        int count =  0;
        while(x != 1){
            
            if( x % 2 == 0 && maxDoubles > 0){
                x /= 2;
                maxDoubles--;            
            }else if(maxDoubles == 0){
                count += x-1;
                break;
            }
            
            else{
                x -= 1;
            }
            count++;
        }
        return count;
    }
}