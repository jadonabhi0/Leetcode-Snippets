class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n, "", ans);
        return ans;
    }


    private void generate(int n, String ansSoFar, List<String> ansList){

        if(n*2 == ansSoFar.length()){
            if(isValidPair(ansSoFar)){
                ansList.add(ansSoFar);
            }
            return;
        }

        generate(n, ansSoFar+"(", ansList);
        generate(n, ansSoFar+")", ansList);

    }

    private boolean isValidPair(String str) {
        int count = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
                if (count < 0) return false; // More closing than opening
            }
        }

        return count == 0; // All opened are closed
    }

}