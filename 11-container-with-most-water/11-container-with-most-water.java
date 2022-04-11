class Solution {
    public int maxArea(int[] height) {
        
       // BRUTEFORCE APPROACH 
        
        // int area = 0 ;
        // for(int i = 0 ; i < height.length-1 ; i ++){
        //     for(int j = i+1 ; j < height.length ; j++){
        //         int n = Math.min(height[i],height[j])*(j-i);
        //         area = Math.max(area,n);
        //     }
        // }
        // return area;
        
        
        
        // TWO POINTER APPROACH
        
        int i = 0 ; int j = height.length-1;
        int vol = 0 ; int wid = 0; int hei = 0;
        
        while(i < j){
            wid = j-i;
            hei = Math.min(height[i],height[j]);
            vol = Math.max(vol,(wid*hei));
            if(height[i] < height[j]) i++;
            else j--;
        }
        
        return vol;
    }
}