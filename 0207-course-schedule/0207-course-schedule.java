class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] map = new ArrayList[numCourses];
        for(int i = 0; i < numCourses ; i++) map[i] = new ArrayList<>();

        for(int[] c : prerequisites){
            map[c[0]].add(c[1]);
        }
        boolean [] vis = new boolean[numCourses];
        boolean [] pathVis = new boolean[numCourses];

        for(int i = 0 ; i < numCourses ; i++){
            if(!vis[i]){
                if(isGraphCyclic(map, vis, pathVis, i)){
                    return false;
                }
            }
        }
        return true;
        
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