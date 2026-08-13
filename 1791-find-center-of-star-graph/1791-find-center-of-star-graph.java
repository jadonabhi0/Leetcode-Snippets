class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int[] graph = new int[n+2];

        for(int[] edge : edges){
            graph[edge[0]]++;
            graph[edge[1]]++;
        }

        System.out.println(Arrays.toString(graph));

        for(int i = 0 ; i < graph.length ; i++){
            if(graph[i] == n) return i;
        }
        return -1;
    }
}