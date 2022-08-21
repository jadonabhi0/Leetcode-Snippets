class Solution {
    public int[] movesToStamp(String stamp, String target) {
        
        char[] st = stamp.toCharArray();
        char[] tr = target.toCharArray();
        List<Integer> temp = new ArrayList<>();
        int[] visited = new int[tr.length];
        boolean starall = true;
    
        while(starall){
            boolean replaced = false;
            for(int i = 0; i <= tr.length-st.length; i++){
                
                if(visited[i] != 1 && canWeReplace(i,tr,st)){
                    replace(i,tr,st);
                    replaced = true;
                    int count = countOfStar(tr);
                    visited[i] = 1;
                    temp.add(i);
                    if(count == tr.length){
                        starall = false;
                        break;
                    }
                }
            }
            if(!replaced)return new int[0];
        }
        
        int[] ans = new int[temp.size()];
        int c = temp.size()-1;
        for(int i : temp){
            ans[c--] = i;
        }
        
        return ans;
        
    }
    
    private boolean canWeReplace(int p, char[] tr, char[] s){
        for(int i = 0; i < s.length; i++){
            if(tr[i+p] != '*' && tr[i+p] != s[i]){
                return false;
            }
        }
        
        return true;
    }
    
    private void replace(int p, char[] tr, char[] s){
         for(int i = 0; i < s.length; i++){
            tr[i+p] = '*';
        }
    }
    private int countOfStar(char[] tr){
        int c = 0;
        for(int i = 0; i < tr.length; i++){
            if(tr[i] == '*')c++;
        }
        
        return c;
    }
}