class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        
        for(int val : arr){
            sum += val;
        }
        
        if(sum % 3 != 0) return false;
        
        sum /= 3;
        
        int cursum = 0;
        int count = 0;
        for(int i =0 ; i < arr.length ; i++){
            cursum += arr[i];
            if(cursum == sum){
                count ++;
                cursum = 0;
            }
            
            
        }
        
        return (count >= 3);
        
    }
}