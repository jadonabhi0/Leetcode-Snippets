class Solution {
    
     static class Node  implements Comparable<Node>{
        int gap;
        int num;

        public Node(int gap, int num) {
            this.gap = gap;
            this.num = num;
        }


        @Override
        public int compareTo(Node o) {
            if (this.gap == o.gap) return this.num - o.num;
            else return this.gap - o.gap;
        }
    }
    public static List<Integer> helper(int[] array, int k, int x){
        PriorityQueue<Node> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0 ; i < array.length ; i++){
            if (q.size() < k){
                q.add(new Node(Math.abs(array[i] - x), array[i]));
            }else{
                if (q.peek().gap > Math.abs(array[i] - x)){
                    q.remove();
                    q.add(new Node(Math.abs(array[i] - x), array[i]));
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()){
            list.add(q.poll().num);
        }
        Collections.sort(list);
        return list;
    }
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        return helper(arr, k, x);
    }
}