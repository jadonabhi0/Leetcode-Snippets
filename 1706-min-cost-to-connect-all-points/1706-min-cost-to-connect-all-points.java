class Solution {

    private int minDis = 0;

    public int minCostConnectPoints(int[][] points) {
        int n =points.length;
        List<List<int[]>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) map.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = findManHatDis(points[i][0], points[i][1], points[j][0], points[j][1]);
                map.get(i).add(new int[]{j, dist});
                map.get(j).add(new int[]{i, dist});
            }
        }
        prims(map, n, 0);
        return minDis;

    }

    private void prims(List<List<int[]>> map, int n, int node){
        boolean[] vis = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{node, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(vis[cur[0]]) continue;
            vis[cur[0]] = true;
            minDis += cur[1];

            for (int[] nbr : map.get(cur[0])) {
                if (!vis[nbr[0]]) {
                    pq.add(nbr);
                }
            }
        }



    }

    private int findManHatDis(int x1, int y1, int x2, int y2){
        return Math.abs(x2 -x1) + Math.abs(y2 - y1);
    }
}