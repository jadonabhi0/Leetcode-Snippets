class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int lo =0;
        int hi = n-1;

        for(int i = 0 ; i < n-2 ; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            lo = i+1;
            hi = n-1;
            while(lo < hi){
                int a = nums[i];
                int b = nums[lo];
                int c = nums[hi];
                int sum = a+b+c;
                if(sum == 0){
                    ans.add(Arrays.asList(a, b, c));
                      // Skip duplicate b
                    while (lo < hi && nums[lo] == nums[lo + 1]) {
                        lo++;
                    }

                    // Skip duplicate c
                    while (lo < hi && nums[hi] == nums[hi - 1]) {
                        hi--;
                    }

                    lo++;
                    hi--;
                }
                
                else if(sum < 0) lo++;
                else hi--;


            }
        }
        return ans;
    }
}