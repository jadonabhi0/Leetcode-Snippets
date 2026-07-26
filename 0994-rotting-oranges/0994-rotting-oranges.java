class Solution {
    int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) q.offer(new int[] { i, j });
            }
        }


        while(!q.isEmpty()){
            int size = q.size();
            boolean hasRottenOrange = false;
            while(size-->0){
                int[] rm = q.poll();
                for(int[] d : dir){
                    int ni = d[0] + rm[0];
                    int nj = d[1] + rm[1];
                    if(ni < 0 || ni == n || nj < 0 || nj== m || grid[ni][nj] != 1) continue;
                    grid[ni][nj] = 2;
                    hasRottenOrange = true;
                    q.offer(new int[]{ni, nj});
                }
            }
            if(hasRottenOrange) count++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1){
                    return -1;
                }
            }
        }


        return count++;
    }
}