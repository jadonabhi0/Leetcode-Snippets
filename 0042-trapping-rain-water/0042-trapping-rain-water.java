class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int tWat = 0;
        int l = 0;
        int r = n-1;
        int lMax = 0;
        int rMax = 0;

        while(l < r){

        lMax = Math.max(lMax, height[l]);
        rMax = Math.max(rMax, height[r]);

        tWat += lMax < rMax ? lMax - height[l++] : rMax - height[r--];
        }

       return tWat;
    }
}