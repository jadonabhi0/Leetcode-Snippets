class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] map = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) map[i] = new ArrayList<>();

        int[] indeg = new int[numCourses];
        for(int[] it: prerequisites){
            indeg[it[1]]++;
            map[it[0]].add(it[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(indeg[i] == 0) q.add(i);
        }

        int cnt = 0;
        while(!q.isEmpty()){
            int rm = q.poll();
            cnt++;
            for(int i : map[rm]){
                indeg[i]--;
                if(indeg[i] == 0) q.offer(i);
            }
        }

        return numCourses == cnt;
    }
}