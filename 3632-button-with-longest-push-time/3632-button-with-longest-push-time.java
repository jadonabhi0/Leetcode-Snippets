class Solution {
    public int buttonWithLongestTime(int[][] events) {
        if(events.length == 1) return events[0][0];
        
        int idx = events[0][0];
        int maxt = events[0][1];
        
        for(int i = 1 ; i < events.length ; i++){
            int time = events[i][1] - events[i-1][1];
            if(time > maxt || (maxt == time && idx > events[i][0])){
                maxt = time;
                idx = events[i][0];
            }
           
        }
        return idx;
        
    }
}