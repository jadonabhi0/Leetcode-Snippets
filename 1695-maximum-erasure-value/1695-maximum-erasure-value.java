class Solution {
    public int maximumUniqueSubarray(int[] nums) {
	int maxSum = Integer.MIN_VALUE;
	int left = 0, right = 0;
	Set<Integer> set = new HashSet<>();
	int sum = 0;
	
	while(right < nums.length) {
		if(set.contains(nums[right])) { 
			sum -= nums[left];
			set.remove(nums[left]);
			left++;
		} else {
			sum += nums[right];
			set.add(nums[right]);
			right++;
			maxSum = Math.max(maxSum, sum);
		}
	}
	
	return maxSum;
}
}