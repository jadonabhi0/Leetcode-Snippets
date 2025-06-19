class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        helper(s, 0, ans, new ArrayList<>());

        return ans;
    }


    private void helper(String s, int idx, List<List<String>> ans, List<String> lst){

        if (idx == s.length()) {
            ans.add(new ArrayList<>(lst));
            return;
        }


        for(int i = idx ; i < s.length() ; i++){
            String preStr = s.substring(idx, i+1);

            if(isPalindrome(preStr)){
                lst.add(preStr);
                helper(s, i+1, ans, lst);
                lst.remove(lst.size() - 1);
            }
        }

        return;

    }


    private boolean isPalindrome(String s){

        int i = 0;
        int j = s.length()-1;

        while(i <= j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }

        return true;
    }
}