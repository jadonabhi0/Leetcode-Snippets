class Solution {
    public List<Integer> getRow(int r) {
        List<Integer> list = new LinkedList<>();
        for(int i = 0 ; i <= r ; i++){
            if(i == 0) list.add(1);
            else{
                for(int j = list.size()-1 ; j > 0 ; j--){
                    list.set(j, list.get(j)+list.get(j-1));
                }
                list.add(1);
            }
        }
        
        return list;
    }
}