class Solution {
    public int[] countBits(int n) {
        int[] array = new int[n+1];
        for(int i = 1 ; i < array.length ; i++){
            array[i] = array[i>>1]+(i%2);
        }
        return array;
    }
}