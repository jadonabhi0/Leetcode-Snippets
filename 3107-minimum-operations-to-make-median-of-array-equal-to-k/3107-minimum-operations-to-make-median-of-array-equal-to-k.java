class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {

        Arrays.sort(nums);

        int n = nums.length;
        int mid = n / 2;

        long ans = 0;

        if (nums[mid] < k) {

            for (int i = mid; i < n; i++) {
                if (nums[i] < k) {
                    ans += (k - nums[i]);
                }
            }

        } else {

            for (int i = mid; i >= 0; i--) {
                if (nums[i] > k) {
                    ans += (nums[i] - k);
                }
            }
        }

        return ans;
    }
}