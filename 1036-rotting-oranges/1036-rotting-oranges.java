class Solution {

    class Pair {
        int i, j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;

        // count fresh oranges & enqueue rotten ones
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0; // no fresh oranges at all

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int minutes = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            minutes++; // new minute starts
            for (int k = 0; k < size; k++) {
                Pair cur = q.poll();
                for (int[] d : dir) {
                    int ni = cur.i + d[0];
                    int nj = cur.j + d[1];

                    if (ni < 0 || ni >= n || nj < 0 || nj >= m || grid[ni][nj] != 1) continue;

                    grid[ni][nj] = 2;
                    fresh--;
                    q.add(new Pair(ni, nj));
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}
