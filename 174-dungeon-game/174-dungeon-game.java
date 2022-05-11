class Solution {
    
    
    public static int help(int[][] mt, int i, int j,Map<String, Integer> map){
       
        if(i >= mt.length || j >= mt[0].length){
            return Integer.MAX_VALUE;
        }
        
        String key = i+"x"+j;
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        int hel = Math.min( help(mt, i+1,j,map),help(mt, i, j+1,map));
        
        if(hel == Integer.MAX_VALUE) {
            hel = 1;
        }
        
        int res = Math.max(hel-mt[i][j], 1);
        map.put(key, res);
        
        return res;
    }
    public int calculateMinimumHP(int[][] dungeon) {
        
        Map<String, Integer> map = new HashMap<>();
        return help(dungeon,0,0, map);
        
    }
}