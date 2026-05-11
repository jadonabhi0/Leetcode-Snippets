class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        int[][] dir = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);

        pq.add(new int[]{grid[0][0], 0, 0});
        vis[0][0] = true;

        int maxTime =  -1;

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int val = node[0];
            int i = node[1];
            int j = node[2];
            vis[i][j] = true;
            maxTime = Math.max(maxTime, val);
            if(i == n-1 && j == n-1) return maxTime;

            for(int[] d : dir){
                int ni = d[0] + i;
                int nj = d[1] + j;
                if(ni < 0 || ni >= n || nj < 0 || nj >= n || vis[ni][nj]) continue;
                pq.offer(new int[]{grid[ni][nj], ni, nj});
            }
        }

        return maxTime;
    }
}