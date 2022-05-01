class Solution {
    public int largestInteger(int num) {
    
        PriorityQueue<Integer> even = new PriorityQueue<>();
        PriorityQueue<Integer> odd = new PriorityQueue<>();
        
        int temp = num;
        
        while(temp > 0){
            int rem = temp%10;
            
            if(rem % 2 == 0){
                even.add(rem);
            }else{
                odd.add(rem);
            }
            
            temp /= 10;
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        while(num > 0){
            int rm = num%10;
            
            if(rm % 2 == 0){
                sb.insert(0,even.poll());
            }
            else{
                sb.insert(0,odd.poll());
            }
            
            num /= 10;
        }
        
        return Integer.parseInt(sb.toString());
    }
}