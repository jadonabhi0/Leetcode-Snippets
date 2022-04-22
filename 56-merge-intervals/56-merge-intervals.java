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
}