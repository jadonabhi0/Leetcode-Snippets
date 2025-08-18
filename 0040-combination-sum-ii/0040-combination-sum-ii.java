class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // sort to handle duplicates
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] cand, int target, int start, List<Integer> curr, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < cand.length; i++) {
            if (i > start && cand[i] == cand[i - 1]) continue; // skip duplicates at same depth
            if (cand[i] > target) break; // pruning since array is sorted

            curr.add(cand[i]);
            backtrack(cand, target - cand[i], i + 1, curr, ans); // move to next index
            curr.remove(curr.size() - 1);
        }
    }
}
