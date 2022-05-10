class Solution {
    public int largestRectangleArea(int[] array) {
        
        int[] rb = new int[array.length];
        int[] lb = new int[array.length];
        
        Stack<Integer> st = new Stack<>();
        
        st.push(array.length-1);
        rb[array.length-1] = array.length;
        
        // finding the right minimum
        for(int i = array.length-2 ; i >= 0 ; i--){
            while(st.size() > 0 && array[i] <= array[st.peek()]){
                st.pop();
            }
            
            if(st.size() == 0){
                rb[i] = array.length;
            }
            
            else{
                rb[i] = st.peek();
            }
            
            st.push(i);
        }
         
        
        // finding the lift minimum
        st = new Stack<>();
        st.push(0);
        lb[0] = -1;
        
        for(int i = 1 ; i < array.length ; i++){
            while(st.size() > 0 && array[i] <= array[st.peek()]){
                st.pop();
            }
            
            if(st.size() == 0 ){
                lb[i] = -1;
            }
            
            else{
                lb[i] = st.peek();
            }
            
            st.push(i);
        }
    
        // area
        int maxArea = 0;
        
        for(int i = 0 ; i < array.length ; i++){
            int width = rb[i] - lb[i] - 1;
            int area = width * array[i];
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
}