class Solution {

    class Pair{
        int src, step, wt;
        public Pair(int src, int wt, int step){
            this.src = src;
            this.step = step;
            this.wt = wt;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) { 
        List<List<Pair>> map = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) map.add(new ArrayList<>());

        for (int i = 0; i < flights.length; i++) {
            map.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2], 0));
        }

        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, 0, 0));

        while(!q.isEmpty()){
            Pair cur = q.poll();

            if(cur.step > k) continue;

            for(Pair nbr : map.get(cur.src)){
                if(cur.wt + nbr.wt < dis[nbr.src]){
                    dis[nbr.src] = cur.wt + nbr.wt;
                    q.offer(new Pair(nbr.src, cur.wt + nbr.wt, cur.step + 1));
                }
            }
        }

        return dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst];
    }
}