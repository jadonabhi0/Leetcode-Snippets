import java.util.*;
import java.lang.*;
class Solution {
 public static int findPeakElement(int[] nums) {
        int[] array = nums.clone();
        Arrays.sort(nums);
        int num = nums[nums.length-1];
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            if(array[low] == num){
                return low;
            }else if(array[high] == num){
                return high;
            }else{
                low++;
                high--;
            }
        }
        return -1;
    }
}