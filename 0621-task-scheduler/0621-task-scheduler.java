class Solution {

    class Task{
        char task;
        int fr;
        int sTime;

        public Task(char task, int fr, int sTime){
            this.task = task;
            this.fr = fr;
            this.sTime = sTime;
        }
    }


    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> frMap = new HashMap<>();
        PriorityQueue<Task> pq = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.fr , t1.fr));
        Queue<Task> q = new LinkedList<>();

        // frq cnt
        for(char ch : tasks) frMap.put(ch, frMap.getOrDefault(ch, 0) + 1);

        // adding to pq 
        for(char ch : frMap.keySet()) pq.offer(new Task(ch, frMap.get(ch), 0));
        
        int time = 0;
        while(!q.isEmpty() || !pq.isEmpty()){
            time++;

            Task sTask = null;  
            if(!pq.isEmpty()){
                sTask = pq.poll();
                sTask.fr--;
                if(sTask.fr > 0){
                    sTask.sTime = time+n;
                    q.offer(sTask);
                }
            }

            if(!q.isEmpty()){
                if(q.peek().sTime == time){
                    Task rm = q.poll();

                    pq.offer(rm);
                }
            }

        }

        return time;
    }
}