class Solution {
    
    // static int [] array = new int[]{-1,-1};
    //  public static int[] searchRangee(int[] nums, int target,int index) {
    //     if (nums[index] == target)
    //     {
    //         array[1] = index;
    //     }
    //     if (index == nums.length-1){
    //         return array;
    //     }
    //     searchRangee(nums,target,index+1);
    //     if (nums[index] == target){
    //         array[0] = index;
    //         return array;
    //     }
    //     return array;
    // }
    
    
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = start+(end-start)/2;
        int[] ans = new int[2];
        ans[0]=-1;
        ans[1]=-1;
        
        while(start<=end){ // first occurance
            mid = start+(end-start)/2;
            if(nums[mid]==target){
                ans[0]=mid;
                end=mid-1;
            }else if(nums[mid]>target){
                end = mid-1;
            }else if(nums[mid]<target){
                start = mid+1;
            }
        }
        
        start = 0;
        end = nums.length-1;
        mid = start+(end-start)/2;
        while(start<=end){ // second occurance
            mid = start+(end-start)/2;
            if(nums[mid]==target){
                ans[1]=mid;
                 start=mid+1;
            }else if(nums[mid]>target){
                end = mid-1;
            }else if(nums[mid]<target){
                start = mid+1;
            }
        }
        
        return ans;
    }
        
    
}