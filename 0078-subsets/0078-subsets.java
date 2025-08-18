class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return generate(nums, 0, new ArrayList<>(), new ArrayList<>());
    }

    public List<List<Integer>> generate(int[] nums, int idx, List<List<Integer>> ans, List<Integer> lst) {
        
        if(idx == nums.length){
            ans.add(new ArrayList<>(lst));
            return ans;
        }

        lst.add(nums[idx]);
        generate(nums, idx + 1, ans, lst);
        lst.remove(lst.size() -1 );
        generate(nums, idx + 1, ans, lst);
        return ans;
    }
   
}