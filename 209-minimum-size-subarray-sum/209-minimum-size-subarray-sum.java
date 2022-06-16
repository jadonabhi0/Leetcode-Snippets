class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0 ;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int temp = 0;
        while(low < nums.length){
                for (int i = low ; i < nums.length ; i++){  //2,1,2,4,3,9
                    sum+=nums[i];
                    if (sum>=target){
                        temp = i-low+1;
                        res = Math.min(res,temp);
                        break;

                    }
                }
            sum=0;
            low+=1;

        }
        return (res != Integer.MAX_VALUE) ? res : 0;
    }
}