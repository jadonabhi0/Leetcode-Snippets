class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(n, 0, 0, "", ans);
        return ans;
    }

    private void backtrack(int n, int open, int close, String current, List<String> ans) {
        if (current.length() == n * 2) {
            ans.add(current);
            return;
        }

        if (open < n) {
            backtrack(n, open + 1, close, current + "(", ans);
        }

        if (close < open) {
            backtrack(n, open, close + 1, current + ")", ans);
        }
    }
}
