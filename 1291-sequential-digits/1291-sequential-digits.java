class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String str = "123456789";
        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i < str.length() ; i++ ){
            for(int j = 0 ; j <= i ; j++){
                String s = str.substring(j, i+1);
                int n = Integer.parseInt(s);
                if(n >= low && n <= high){
                    list.add(n);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}