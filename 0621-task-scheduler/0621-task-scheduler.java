class Solution {
    class Task{
        char task;
        int fr;
        int sTime;
        Task(char task, int fr, int sTime){
            this.task = task;
            this.fr = fr;
            this.sTime = sTime;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int interval = 0;
        HashMap<Character, Integer> frMap = new HashMap<>();
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> b.fr - a.fr);
        Queue<Task> q = new LinkedList<>();

        for(char ch : tasks) frMap.put(ch, frMap.getOrDefault(ch, 0)+1);
        for(char ch : frMap.keySet()) pq.add(new Task(ch, frMap.get(ch), 0));

        while(!q.isEmpty() || !pq.isEmpty()){
            interval++;
            Task poll;
            if(!pq.isEmpty()){
                poll = pq.poll();
                poll.fr--;
                if(poll.fr > 0){
                    poll.sTime = interval + n;
                    q.add(poll);
                }
            }

            if(!q.isEmpty()){
                if(q.peek().sTime == interval){
                    Task rm = q.poll();
                    pq.offer(rm);
                }
            }

        }

        return interval;
    }

}