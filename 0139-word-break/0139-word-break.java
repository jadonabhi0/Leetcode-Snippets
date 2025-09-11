class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String word : wordDict) set.add(word);
        return find(s, set, new HashMap<>());
    }

    private boolean find(String s, Set<String> wordDict, Map<String,Boolean> dp){

        if(s.length() == 0) return true;

        if(dp.containsKey(s)) return dp.get(s);

        for(int i = 0 ; i < s.length() ; i++){

            String asf = s.substring(0, i+1);
            String ros = s.substring(i+1);

            if(wordDict.contains(asf)){
                if(find(ros, wordDict, dp)){
                    dp.put(s, true);
                    return true;
                } 
            }  
        }
        dp.put(s, false);
        return false;

    }

}