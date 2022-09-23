class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length-1 ; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int a = nums[i];
            int l = i+1;
            int r = nums.length -1;
            
            while(l < r){
                if(nums[l] + nums[r] == -a){
                    list.add(Arrays.asList(a, nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l+1]) l++;
                    while(l < r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }
                else if(nums[l] + nums[r] > -a) r--;
                else if(nums[l] + nums[r] < -a) l++;
            }
        }
          return list;  
        }
        
    }
