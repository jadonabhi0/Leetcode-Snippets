class Solution {
    public int[] runningSum(int[] nums) {
        int[] array = new int[nums.length];
        array[0] = nums[0];
        for(int i = 1 ; i < nums.length ; i++) array[i] = nums[i] + array[i-1];
        return array;
    }
}