//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    class Pair{
        int x;
        int y;
        
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        if(A[0][0] == 0) return -1;
        int[][] dir = new int[][]{{0, 1}, {0,-1}, {1,0}, {-1, 0}};
        boolean[][] vis = new boolean[N][M];
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));
        vis[0][0] = true;
        while(!q.isEmpty()){
           int size = q.size();
           while(size-->0){
                Pair rm = q.poll();
                if(rm.x == X && rm.y == Y) return ans;
                for(int[] ar : dir){
                    int nx = rm.x+ar[0];
                    int ny = rm.y+ar[1];
                    if( nx < 0 || nx == N || ny < 0 || ny == M || A[nx][ny] == 0 || vis[nx][ny]) continue;
                    q.offer(new Pair(nx, ny));
                    vis[nx][ny] = true;
                }
           }
           ans++;
        }
        return -1;
    }
}