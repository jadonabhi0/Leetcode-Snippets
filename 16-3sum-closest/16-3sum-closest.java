class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
		int closest=target>=0?Integer.MAX_VALUE:Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++){
			int l=i+1,r=nums.length-1;
			while(l<r){
				int sum=nums[i]+nums[l]+nums[r];
				if(Math.abs(sum-target)<=Math.abs(closest-target))
					closest=sum;
				if(sum<target)l++;
				else r--;
			}
		}
		return closest;
    }
}