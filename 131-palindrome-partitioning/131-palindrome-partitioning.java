class Solution {
    
    public boolean isPallindrome(String s){
        int lf = 0;
        int rt = s.length()-1;
        
        if(lf == rt) return true;
        while(lf <= rt){
            char c1 = s.charAt(lf);
            char c2 = s.charAt(rt);
            if(c1 == c2){
                lf++;
                rt--;
            }else{
                return false;
            }
            
        }
        return true;
    }
    
    
    public void helper(String s, List<String> list, List<List<String>> ans){
        
        if(s.length() == 0){
            ans.add(new ArrayList(list));
            return;
        }
        
        for(int i = 0 ; i < s.length() ; i++){
            String prefix = s.substring(0,i+1);
            String ros = s.substring(i+1);
            if(isPallindrome(prefix)){
                list.add(prefix);
                helper(ros, list, ans);
                list.remove(list.size()-1);
            }
        }
    }
    
    
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper(s,list, res);
        return res;
        
        
    }
}