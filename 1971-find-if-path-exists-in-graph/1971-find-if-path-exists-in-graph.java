class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        List<List<Integer>> adj = new ArrayList<>();

        // Create n empty lists
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return dfs(adj, source, destination, new boolean[n]);
    }

    private boolean dfs(
            List<List<Integer>> adj,
            int src,
            int destination,
            boolean[] vis) {

        // Destination reached
        if (src == destination) {
            return true;
        }

        vis[src] = true;

        for (int nbr : adj.get(src)) {

            if (!vis[nbr]) {

                boolean exists = dfs(adj, nbr, destination, vis);

                if (exists) {
                    return true;
                }
            }
        }

        return false;
    }
}