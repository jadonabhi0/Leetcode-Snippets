class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        Deque<Integer> d = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        k = k%(row*col);
        
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                d.offer(grid[i][j]);
            }
        }
        for(int i = 0 ; i < k ; i++){
            d.offerFirst(d.removeLast());
        }
        
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                list.add(d.poll());
            }
            res.add(list);
            list = new LinkedList();
        }
        
        return res;
    }
}