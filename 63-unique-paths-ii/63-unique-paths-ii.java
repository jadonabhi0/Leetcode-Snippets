class Solution {
    
   public int uniquePathsWithObstacles (int[][] obstacleGrid) {
       HashMap<String, Integer> map = new HashMap<>();
			return path(obstacleGrid, 0, 0, map);
	}

	public static int path(int[][] board, int i, int j, HashMap<String ,Integer> map){
        String key = i+"x"+j;
        if (map.containsKey(key)){
            return map.get(key);
        }

        if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == 1){
            return 0;
        }
        if(i == board.length-1 && j == board[0].length-1){
            return 1;
        }
        int a = path(board, i+1, j, map) ;
        int b = path(board, i, j+1, map);
        map.put(key,a+b);
        return a+b;
    }

}