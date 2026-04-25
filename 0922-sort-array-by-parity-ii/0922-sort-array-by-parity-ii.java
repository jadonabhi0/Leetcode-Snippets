class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int lo = 0;
        int c = 0;

        while(lo < n){
            if(nums[lo] % 2 == 0){
                lo+=2;
                continue;
            }

            while(c < n){
                if(c%2 != 0 && nums[c]%2 == 0){
                    int temp = nums[c];
                    nums[c] = nums[lo];
                    nums[lo] = temp;
                    break;
                }
                c++;
            }
           
        }
        return nums;
    }
}