class Solution {
    public static String[] keypad = {"","", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new LinkedList<>();
        return combine(digits, 0, new ArrayList<>(), "");
    }

 
    private List<String> combine(String dig, int idx, List<String> ans, String comb){
        
        if(idx == dig.length()){
            ans.add(comb); // O(1)
            return ans;
        }
        
        char ch = dig.charAt(idx);
        String s = keypad[ch-'0'];

        for(int i = 0 ; i < s.length() ; i++){
            combine(dig, idx+1, ans, comb + s.charAt(i));
        }
        return ans;
    }


}