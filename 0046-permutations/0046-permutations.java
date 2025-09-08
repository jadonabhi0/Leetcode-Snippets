class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        return generate(nums, 0, new ArrayList<>());
    }

    public List<List<Integer>> generate(int[] nums,int idx, List<List<Integer>> ans) {
        if(idx == nums.length){
            List<Integer> lst = new ArrayList<>();
            for(int i : nums) lst.add(i);
            ans.add(new ArrayList<>(lst));
            return ans;
        }

        for(int i = idx ; i < nums.length ; i++){
            swap(nums, idx, i);
            generate(nums, idx+1, ans);
            swap(nums, idx, i);
        }
        return ans;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}