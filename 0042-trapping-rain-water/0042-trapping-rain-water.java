class Solution {
    public int trap(int[] height) {
        int lMax = 0, rMax = 0, l = 0, r = height.length-1,tWat = 0;
        while(l < r){
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);
            tWat += lMax < rMax ? lMax-height[l++] : rMax - height[r--];
        }
        return tWat;
    }
}