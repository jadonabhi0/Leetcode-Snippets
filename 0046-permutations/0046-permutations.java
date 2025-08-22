class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        return generate(nums, 0, new ArrayList<>(), new ArrayList<>(), new boolean[nums.length]);
    }

    public List<List<Integer>> generate(int[] nums,int idx, List<List<Integer>> ans, List<Integer> lst, boolean[] vis) {
        
        if(idx == nums.length){
            ans.add(new ArrayList<>(lst));
            return ans;
        }
        
        for(int i = 0 ; i < nums.length ; i++){
            if(!vis[i]){
                vis[i] = true;
                lst.add(nums[i]);
                generate(nums, idx + 1, ans, lst, vis);
                lst.remove(lst.size() -1 );
                vis[i] = false;
            } 
           
        }

        return ans;
    }

}