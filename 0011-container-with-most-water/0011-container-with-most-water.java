class Solution {
    public int maxArea(int[] height) {

        int i = 0 , j = height.length-1, n = height.length;
        int maxWater = 0;

        while(i < j){

            int water = (j - i) * Math.min(height[i], height[j]);

            maxWater = Math.max(water, maxWater);

            if(height[i] > height[j]) j--;
            else i++;

        }
        return maxWater;
    }
}