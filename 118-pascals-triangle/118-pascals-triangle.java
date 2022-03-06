class Solution {
    
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
        for(int i = 0 ; i < numRows ; i++){
           List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j = 1 ; j < i ; j++){
                row.add(list.get(i-1).get(j-1)+list.get(i-1).get(j));
            }
            if(i!=0){
                row.add(1);
            }
            list.add(row);
        }
        return list;
    }
}