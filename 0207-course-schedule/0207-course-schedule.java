class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //============ using DFS ================
        // ArrayList<Integer>[] map = new ArrayList[numCourses];
        // for(int i = 0; i < numCourses ; i++) map[i] = new ArrayList<>();

        // for(int[] c : prerequisites){
        //     map[c[0]].add(c[1]);
        // }
        // boolean [] vis = new boolean[numCourses];
        // boolean [] pathVis = new boolean[numCourses];

        // for(int i = 0 ; i < numCourses ; i++){
        //     if(!vis[i]){
        //         if(isGraphCyclic(map, vis, pathVis, i)){
        //             return false;
        //         }
        //     }
        // }
        // return true;

        // ===================== using BFS (Khans algo)======================


        ArrayList<Integer>[] map = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) map[i] = new ArrayList<>();

        int[] indeg = new int[numCourses];
        for (int[] c : prerequisites) {
            map[c[1]].add(c[0]);   // edge: b -> a
            indeg[c[0]]++;         // a has an incoming edge
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) q.offer(i);
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            int rm = q.poll();
            cnt++;
            for (int nbr : map[rm]) {
                indeg[nbr]--;
                if (indeg[nbr] == 0) q.offer(nbr);
            }
        }

        return cnt == numCourses;
    }
        


    private boolean isGraphCyclic(ArrayList<Integer>[] graph, boolean[] vis, boolean[] pathVis, int node) {
        vis[node] = true;
        pathVis[node] = true;

        for (int nbr : graph[node]) {
            if (!vis[nbr]) {
                if (isGraphCyclic(graph, vis, pathVis, nbr)) return true;
            } else if (pathVis[nbr]) {
                return true; // cycle detected
            }
        }

        pathVis[node] = false; // backtrack
        return false;
    }
}