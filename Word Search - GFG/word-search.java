//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean dfs(char[][] board, String word, int i, int j, int n, int m, int idx){
        if(idx == word.length()) return true;
        if(i < 0 || j < 0 || i == n || j == m || word.charAt(idx) != board[i][j] || board[i][j] == '*') return false;
        char temp = board[i][j];
        board[i][j] = '*';
        boolean a = dfs(board, word, i-1, j, n, m, idx+1);
        boolean b = dfs(board, word, i+1, j, n, m, idx+1);
        boolean c = dfs(board, word, i, j-1, n, m, idx+1);
        boolean d = dfs(board, word, i, j+1, n, m, idx+1);
        board[i][j] = temp;
        return a || b || c || d;
        
    }
    public boolean isWordExist(char[][] board, String word)
    {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] == word.charAt(0) && dfs(board,word,i, j,n, m, 0)) return true;
            }
        }
        return false;
    }
}