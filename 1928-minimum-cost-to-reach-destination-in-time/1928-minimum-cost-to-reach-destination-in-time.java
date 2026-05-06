class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] t : edges) {
            int u = t[0];
            int v = t[1];
            int w = t[2];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        int n = passingFees.length;
        int[][] dp = new int[n][maxTime+1];
        for(int[] arr : dp) Arrays.fill(arr, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[2] - b[2]); // sort by cost

        dp[0][0] = passingFees[0];
        pq.offer(new int[]{0, 0, passingFees[0]}); // node, time, cost

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int dest = curr[0];
            int currTime = curr[1];
            int currFee = curr[2];

            if(dest == n-1) return currFee;

            if (!graph.containsKey(dest)) continue;

            for (int[] nbr : graph.get(dest)) {
                int next = nbr[0];
                int time = nbr[1];

                int newTime = time + currTime;
                if (newTime > maxTime) continue;

                int newCost = currFee + passingFees[next];

                if (newCost < dp[next][newTime]) {
                    dp[next][newTime] = newCost;
                    pq.offer(new int[]{next, newTime, newCost});
                }
            }
        }

       return -1;
    }
}