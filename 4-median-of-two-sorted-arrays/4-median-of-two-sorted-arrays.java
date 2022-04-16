class Solution {
   public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] array = new int[m+n];
        int c = 0;

        int i = 0 ;
        int j = 0 ;

        while(i < m && j < n ){
            if(nums1[i] < nums2[j]){
                array[c++] = nums1[i];
                i++;
            }
            else{
                array[c++] = nums2[j];
                j++;
            }
        }

        if(i < m){
            while(i < m){
                array[c++] = nums1[i++];
            }
        }
        if(j < n){
            while(j < n){
                array[c++] = nums2[j++];
            }
        }

        int len = array.length;
       if(len%2 == 0){
           int ans = ((array[len/2]+array[(len/2)-1]));
           return (double)ans/2;
       }
       float a = array[len/2];
       return (double) a;
       
    }
}