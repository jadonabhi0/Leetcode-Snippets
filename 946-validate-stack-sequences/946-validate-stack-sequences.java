class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int len = pushed.length;
        int j = 0 ;
        for(int i : pushed){
            stack.push(i);
            while(!stack.isEmpty() && j < len && stack.peek() == popped[j] ){
                stack.pop();
                j++;
            }
        }
        return  j==len;
    }
}