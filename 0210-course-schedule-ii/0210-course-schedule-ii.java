class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] map = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) map[i] = new ArrayList<>();
        
        int[] ans = new int[numCourses];
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
            ans[cnt] = rm;
            cnt++;
            for (int nbr : map[rm]) {
                indeg[nbr]--;
                if (indeg[nbr] == 0) q.offer(nbr);
            }
        }

        return cnt == numCourses ? ans : new int[0];
    }
}