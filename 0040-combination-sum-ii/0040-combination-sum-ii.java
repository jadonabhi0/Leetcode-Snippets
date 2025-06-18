class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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

        for(int i = idx ; i < n ; i++){

            if(i > idx && candidates[i] == candidates[i-1]){
                continue;
            }

            if(candidates[i] <= target) {
                lst.add(candidates[i]);
                helper(candidates, target-candidates[i], i+1, n, ans, lst);
                lst.remove(lst.size()-1);
            }else{
                break;
            }

           
        }
    
        return;
    }
}