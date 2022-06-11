class Solution {
public int minOperations(int[] nums, int x) {
int target = -x;
for(int num: nums) target += num;
if(target == 0) return nums.length;
if(target < 0) return -1;
Map<Integer, Integer> map = new HashMap<>();
map.put(0, -1);
int sum = 0, L = 0;
for(int i = 0; i < nums.length; i++) {
sum += nums[i];
L = Math.max(L, i - map.getOrDefault(sum - target, i));
map.put(sum, i);
}
return L > 0 ? nums.length - L : -1;

}
}