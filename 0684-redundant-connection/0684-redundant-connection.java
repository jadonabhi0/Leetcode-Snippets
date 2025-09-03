class Solution {

    class UnionFind {

        private int[] parent;
        private int[] rank;
        int a = 0;
        int b = 0;


        public UnionFind(int n) {
            this.parent = new int[n+1];
            this.rank = new int[n+1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int findUPar(int node) {
            if (parent[node] == node) return node;
            return parent[node] = findUPar(parent[node]); // path compression
        }

        public void unionByRank(int u, int v) {
            int uPar = findUPar(u);
            int vPar = findUPar(v);

            if (uPar == vPar){
                a = u;
                b = v;
                return ;
            }

            if (rank[uPar] > rank[vPar]) {
                parent[vPar] = uPar;
            } else if (rank[vPar] > rank[uPar]) {
                parent[uPar] = vPar;
            } else {
                parent[vPar] = uPar;
                rank[uPar]++;
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind u = new UnionFind(edges.length);
        int[] ans = new int[2];

        for(int[] e : edges){
            u.unionByRank(e[0], e[1]);
        }
        ans[0] = u.a;
        ans[1] = u.b;
        return ans;
        
    }
}