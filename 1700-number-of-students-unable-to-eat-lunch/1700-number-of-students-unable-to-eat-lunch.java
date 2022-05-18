class Solution {
    public int countStudents(int[] students, int[] san) {
       Queue<Integer> line = new LinkedList<>();
        for (int i : students){
            line.offer(i);
        }
        
        Queue<Integer> item = new LinkedList<>();
        
        for(int i : san){
            item.offer(i);
        }
        
        int count = item.size()*line.size();
        
        for(int i = 0 ; i < count ; i++){
            
            if(item.size()>0 && line.size() > 0 && item.peek() == line.peek()){
                item.poll();
                line.poll();
            }else{
                if(line.size()>0){
                    line.offer(line.poll());
                }else{
                    return 0;
                }
            }
            
        }
        return line.size();
    }
}