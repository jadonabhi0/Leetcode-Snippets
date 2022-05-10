class Solution {
    
    public static int larea(int[] array) {
        
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
    
    public int maximalRectangle(char[][] matrix) {
        int lrec = 0;
        int rec = 0;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int[] dp = new int[col];
        
        
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ;  j < col ; j++){
                dp[j] = matrix[i][j] == '1' ? dp[j]+1 : 0;
            }
            rec = larea(dp);
            
            if(rec > lrec){
                lrec = rec;
            }
            
        }
        
        return lrec;
    }
}