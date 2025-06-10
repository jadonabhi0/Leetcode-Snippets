class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, 0, candidates.length, ans, new ArrayList<>());
        return ans;
    }

    private void helper(int[] candidates, int target, int idx, int n, List<List<Integer>> ans, List<Integer> lst){

        if(target == 0){
            ans.add(new ArrayList(lst));
            return;
        }

        if(idx == n){
            return;
        }
        

        if(target >= candidates[idx]){
            lst.add(candidates[idx]);
            helper(candidates, target-candidates[idx], idx, n, ans, lst);
            lst.remove(lst.size()-1);
        }
        
        helper(candidates, target, idx+1, n, ans, lst);

        return;
    }


}