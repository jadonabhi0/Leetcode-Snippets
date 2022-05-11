class Solution {
    
     public static int unique(int i, int j, HashMap<String, Integer> map){
        String key = i+"x"+j;
        if(map.containsKey(key)){
            return map.get(key);
        } 
        if (i < 0 || j < 0){
            return 0;
        }
         else if (i == 0 && j == 0){
             return 1;
         }

         else {
             
            int t = unique( i-1, j, map)+unique(i, j-1, map);
             map.put(key,t);
             return t;
        }


    }
    
    public int uniquePaths(int m, int n) {
        HashMap<String, Integer> map = new HashMap<>();
        return unique(m-1, n-1, map);
    }
}