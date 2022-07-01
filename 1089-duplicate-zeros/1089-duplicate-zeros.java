class Solution {
    public void duplicateZeros(int[] arr) {
      for(int i = 0 ; i < arr.length ; i++){
          if(arr[i] == 0){
              shift(arr,i+1);
              i++;
          }
          
      }
    }
    
    public void shift(int[] array, int idx){
        for(int i = array.length - 1 ; i >= idx ; i--){
            array[i] = array[i-1];
        }
    }
}