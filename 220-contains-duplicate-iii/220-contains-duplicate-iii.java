class Solution {
   	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<nums.length; i++){
            if(i > k){
                set.remove(nums[i-k-1]);
            }
            if(!set.add(nums[i])){
                return true;
            }
            Integer left = set.lower(nums[i]);
            if(left != null && Math.abs((long) left - nums[i]) <= t){
                return true;
            }
            Integer right = set.higher(nums[i]);
            if(right != null && Math.abs((long) right - nums[i]) <= t){
                return true;
            }
        }
        return false;
    }
}