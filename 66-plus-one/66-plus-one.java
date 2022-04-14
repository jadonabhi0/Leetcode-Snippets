class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length -1;
        if(digits[n] != 9){
            digits[n] = digits[n]+1;
            return digits;
        }
        boolean flag = false;
        for(int i = n ; i>=0 ;i--){
            if(i == 0 && digits[i] == 9){digits[i] = 0; flag = true;}
            else if(digits[i] == 9) {digits[i] = 0;continue;}
            else {digits[i] += 1;break;};
        }
        if(flag){
            int array[] = new int[n+2];
            array[0] = 1;
            return array;
        }
        return digits;
    }
}