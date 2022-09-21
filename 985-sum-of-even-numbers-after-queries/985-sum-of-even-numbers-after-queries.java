class Solution {
    
    public int evenSum(int[] array){
        int res = 0;
        for(int i : array){
            if(i % 2 == 0) res += i;
        }
        return res;
    }
    
    public int[] sumEvenAfterQueries(int[] nums, int[][] q) {
        int[] ans = new int[nums.length];
        int c = 0;
        int sum = evenSum(nums);
        for(int[] a : q){
            if(nums[a[1]] % 2 == 0){
                sum -= nums[a[1]];
            }
            nums[a[1]] += a[0];
            
            if(nums[a[1]] % 2 == 0){
                sum += nums[a[1]];
            }
            ans[c++] = sum;
        }
       return ans; 
    }
    
}