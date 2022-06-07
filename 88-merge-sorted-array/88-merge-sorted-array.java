class Solution {
    
//     int count(int[] array){
//         int c = 0;
//         for(int i = 0 ; i < array.length ; i++){
//             if(array[i] == 0){
//                 c++;
//             }
//         }
//         return c;
//     }
    
//     int[] removeZero(int[] array){
//         int n = count(array);
//         int count = 0;
//         int[] arr = new int[array.length-n];
//         for(int i = 0 ; i < array.length ; i++){
//             if(array[i]!=0){
//                 arr[count++] = array[i];
//             }
//         }
//         return arr;
//     }
    
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
//         int[] array1 = removeZero(nums1);
//         int[] array2 = removeZero(nums2);
        
//         int i = 0;
//         int j = 0;
        
    
//         int[] array = new int[m+n];
//         int c = 0;
//         for(int i = 0 ; i < m ;i++){
//             array[c++] = nums1[i];
//         }
//          for(int i = 0 ; i < n ;i++){
//             array[c++] = nums2[i];
//         }
        
//         Arrays.sort(removeZero(array));
        
        
        
        for(int i=0;i<n;i++){
            nums1[m+i]=nums2[i];
        }
        Arrays.sort(nums1);
        
    }
}