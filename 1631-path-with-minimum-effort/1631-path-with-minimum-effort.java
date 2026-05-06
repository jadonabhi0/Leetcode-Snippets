class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] minEff = new int[n][m];
        for (int[] arr : minEff) Arrays.fill(arr, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        pq.add(new int[]{0, 0, 0});
        minEff[0][0] = 0;

        while(!pq.isEmpty()){
            int[] rm = pq.poll();
            int effort = rm[0];
            int i = rm[1];
            int j = rm[2];

            if (effort > minEff[i][j]) continue;
            if (i == n-1 && j == m-1) return effort;

            for(int[] d : dir){
                int ni = i + d[0];
                int nj = j + d[1];

                if (ni < 0 || nj < 0 || ni >= n || nj >= m) continue;

                int diff = Math.abs(heights[i][j] - heights[ni][nj]);
                int newEffort = Math.max(effort, diff);

                if (newEffort < minEff[ni][nj]) {
                    minEff[ni][nj] = newEffort;
                    pq.offer(new int[]{newEffort, ni, nj});
                }
            }
        }
        return 0;
    }
}