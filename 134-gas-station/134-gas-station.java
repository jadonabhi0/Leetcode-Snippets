class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        
        int totalcost = 0;
        int totalgas = 0;
        
        for(int i = 0 ; i < n ; i++){
            totalgas += gas[i];
            totalcost += cost[i];
            
        }
        
        if(totalgas < totalcost){return -1;}
        
        int start = 0;
        int tankmainpetrol = 0;
        
        for(int i = 0 ; i < n ; i++){
            
            tankmainpetrol += gas[i] - cost[i];
            
            if(tankmainpetrol < 0){
                start = 1 + i;
                tankmainpetrol = 0;
            }
            
        }
        
        return start;
    }
}