class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[]{0, 0, grid[0][0]});

        int elevationt = 0;

        while(!pq.isEmpty()){

            int[] cur = pq.poll();
            vis[cur[0]][cur[1]] = true;
            elevationt = Math.max(elevationt, cur[2]);

            if(cur[0] == n-1 && cur[1] == n-1) return elevationt;

            for(int[] d : dir){
                int ni = d[0] + cur[0];
                int nj = d[1] + cur[1];

                if(ni < 0 || ni == n || nj < 0 || nj == n || vis[ni][nj]) continue;
                pq.offer(new int[]{ni, nj, grid[ni][nj]});
            }

        }
        return -1;
    }
}