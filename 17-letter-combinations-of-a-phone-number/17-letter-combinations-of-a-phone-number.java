class Solution {
    
    public static String[] keypad = {"","", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void keyComb(String str,int index,String comb, List<String> list){

        if (index == str.length()){
            list.add(comb);
            return;
        }

        char ch = str.charAt(index);
        String s = keypad[ch-'0'];
        for(int i = 0 ; i <  s.length() ; i++){
            keyComb(str,index+1,comb+s.charAt(i),list);
        }

    }
    
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new LinkedList<>();
        List<String> list = new LinkedList<>();
        keyComb(digits, 0, "", list);
        return list;
    }
}