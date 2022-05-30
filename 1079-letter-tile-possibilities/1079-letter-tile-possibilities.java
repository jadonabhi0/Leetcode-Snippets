class Solution {
    
     int count = 0;
    public void help(char[] array, boolean[] vis, int idx ){
        
        if(idx == array.length) return;
        
        for(int i = 0 ; i < array.length ; i++){
            if(vis[i]) continue;
            if(i > 0 && array[i] == array[i-1] && !vis[i-1]) continue;
            count++;
            vis[i] = true;
            help(array, vis, idx+1);
            vis[i] = false;
            
        }
        
    }
    
    public int numTilePossibilities(String tiles) {
        boolean[] vis = new boolean[tiles.length()];
        char[] array = tiles.toCharArray();
        Arrays.sort(array);
        help(array, vis, 0);
        return count;
    }
}