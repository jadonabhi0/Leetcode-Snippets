class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++){
            queue.offer(i);
        }
        
        while(queue.size()>1){
            int delete = k-1;
            while(delete>0){
                queue.offer(queue.remove());
                delete--;
            }
            
            queue.remove();
        }
        
        return queue.remove();
    }
}