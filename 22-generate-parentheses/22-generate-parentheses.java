class Solution {
    
    
     public List<String> generateAll(List<String> list, String s, int o , int c, int n){
        if(n*2 == s.length()){
            list.add(s);
            return list;
        }

        if (o<n) generateAll(list, s+'(',o+1, c, n);
        if (c<o) generateAll(list, s+')',o, c+1, n);
        return list;

    }
    
    
    public List<String> generateParenthesis(int n) {
        return generateAll(new LinkedList<>(), "", 0, 0, n);
    }
}