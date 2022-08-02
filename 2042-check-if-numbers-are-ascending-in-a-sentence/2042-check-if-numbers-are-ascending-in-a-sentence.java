class Solution {
    public boolean areNumbersAscending(String s) {
        int prev = Integer.MIN_VALUE;
        String[] arr = s.split(" ");
        for(String str : arr){
            try{
                int number = Integer.parseInt(str);
                if(prev >= number) return false;
                prev = number;
            }catch(Exception e){}
        }
        return true;
    }
}