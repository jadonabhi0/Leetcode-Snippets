class Solution {
    int[][] dir = new int[][]{{1,0}, {-1,0}, {0, 1}, {0,-1}};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 2) q.offer(new int[]{i,j});
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            boolean hasRottenInThisMin = false;
            while(size-->0){
                int[] rm = q.poll();
                for(int[] d : dir){
                    int ni = rm[0] + d[0];
                    int nj = rm[1] + d[1];
                    if(ni < 0 || ni >= n || nj < 0 || nj >= m || grid[ni][nj] != 1) continue;
                    grid[ni][nj] = 2;
                    q.offer(new int[]{ni, nj});
                    hasRottenInThisMin = true;
                }
            }
            if(hasRottenInThisMin) count++;
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1) return -1;
            }
        }

        return count;
    }

    

}