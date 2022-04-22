class Solution {
    
    public static int[][] merge(int[][] in) {
        Arrays.sort(in, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> mer = new LinkedList<>();
        for(int[] i : in){
            if(mer.isEmpty() || mer.getLast()[1] < i[0]){
                mer.add(i);
            }else{
                mer.getLast()[1] = Math.max(mer.getLast()[1],i[1]);
            }
        }
        return mer.toArray(new int[mer.size()][]);
    } 
    
    public int[][] insert(int[][] in, int[] newin) {
        
        if(in.length == 0){
            int[][] ar = new int[1][2];
            ar[0] = newin;
            return ar;
        }
        LinkedList<int[]> mer = new LinkedList<>();
        for(int[] i : in){
           if(mer.isEmpty() && newin[0] == 0){
               mer.add(newin);
               mer.add(i);
           }
           else if(mer.isEmpty()){
               if(i[1]>newin[0]){
                   mer.add(newin);
                   mer.add(i);
               }else{
                   mer.add(i);
                   mer.add(newin);
               }
           } 
           else if(mer.getLast()[1]<newin[0]){
                mer.add(newin);
                mer.add(i);
           } 
           else{
               mer.add(i);
           } 
        }
       
        return merge(mer.toArray(new int[mer.size()][]));
    }
}