class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return generate(nums, 0, new ArrayList<>(), new ArrayList<>());
    }

    private List<List<Integer>> generate(int[] nums, int idx, List<List<Integer>> ans, List<Integer> lst){
        // if(idx == nums.length){
        //     return ans;
        // }

            ans.add(new ArrayList<>(lst));


         for(int i = idx ; i < nums.length ; i++){
            if(i > idx  && nums[i-1] == nums[i]){
                continue;
            }

            lst.add(nums[i]);
            generate(nums, i+1 , ans, lst);
            lst.remove(lst.size() - 1);
         }
          
        

        return ans;
    }
}