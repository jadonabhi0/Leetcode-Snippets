import java.util.*;

class Solution {

    class Pair {
        int v; // vertex
        int l; // label

        public Pair(int v, int l) {
            this.v = v;
            this.l = l;
        }
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1);

        for (int i = 0; i < n; i++) {
            if (vis[i] == -1) {
                if (!check(graph, vis, i)) return false;
            }
        }
        return true;
    }

    private boolean check(int[][] graph, int[] vis, int start) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(start, 0));

        while (!q.isEmpty()) {
            Pair rm = q.poll();

            if (vis[rm.v] != -1) {
                if (vis[rm.v] != rm.l) return false;
            } else {
                vis[rm.v] = rm.l;
            }

            // add neighbors
            for (int nbr : graph[rm.v]) {
                if (vis[nbr] == -1) {
                    q.offer(new Pair(nbr, 1 + rm.l));
                }
            }
        }

        return true;
    }
}
