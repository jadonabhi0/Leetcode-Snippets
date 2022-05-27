class Solution {
    public int numberOfSteps(int num) {
        int count = 0 ;
        
        while(num != 0){
            if(num%2 == 0){
                count+=1;
                num = num/2;
            }else{
                num = num-1;
                count+=1;
            }
        }
        return count;
    }
}