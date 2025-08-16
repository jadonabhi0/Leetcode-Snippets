class Solution {

    class Pair{
        int dis;
        int[] cord;

        public Pair(int dis, int[] cord){
            this.dis = dis;
            this.cord = cord;
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.dis, p1.dis));

        for(int[] c : points){
            
            int dis = c[0] * c[0] + c[1] * c[1];
            pq.add(new Pair(dis, c));

            if(pq.size() > k) pq.poll();

        }

        int[][] ans = new int[k][2];

        for(int i = 0 ; i < k ; i++){
            ans[i] = pq.poll().cord;
        }
        

        return ans;
    }
}