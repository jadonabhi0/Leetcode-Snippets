class Solution {
    
    public void word(String s, List<String> wordDict, String ans, List<String> list){
        if(s.length() == 0){
           list.add(ans.strip());
            return;
        }
        
        for(int i = 0 ; i < s.length() ;i++){
            String left = s.substring(0,i+1);
            if(wordDict.contains(left)){
                String right = s.substring(i+1);
                word(right, wordDict,ans+left+" ",list);
            }
        }
    }
    
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new LinkedList<>();
        word(s, wordDict, "", list);
        return list;
         
    }
}