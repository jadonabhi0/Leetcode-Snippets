import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Graph adjacency list: node -> (neighbor, weight)
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] t : times) {
            graph[t[0]].add(new int[]{t[1], t[2]});
        }

        // Distances array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Min-heap for Dijkstra (distance, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], node = cur[1];

            if (d > dist[node]) continue;

            for (int[] edge : graph[node]) {
                int nei = edge[0], w = edge[1];
                if (dist[nei] > d + w) {
                    dist[nei] = d + w;
                    pq.offer(new int[]{dist[nei], nei});
                }
            }
        }

        // Find max distance
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
