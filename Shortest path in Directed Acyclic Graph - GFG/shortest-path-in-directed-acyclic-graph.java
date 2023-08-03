//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    
    public void helper(ArrayList<int[]>[] map, int[] ans, int src, PriorityQueue<int[]> q ){
        	
		q.add(new int[]{src, 0});
		ans[src] = 0;
        
        while(!q.isEmpty()){
            int [] ar = q.poll();
            
            int node = ar[0];
            int dis = ar[1];
            
            for(int[] nbr : map[node]){
                if(nbr[1]+dis < ans[nbr[0]]){
                    ans[nbr[0]] = nbr[1]+dis;
                    q.add(new int[]{nbr[0], nbr[1]+dis});
                }
            }
		    
        }
        
        for(int i = 0 ; i < map.length ; i++){
          ans[i] = ans[i] == Integer.MAX_VALUE ? -1 : ans[i];
        }
        
        
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
	    
	    ArrayList<int[]>[] map = new ArrayList[N];
	    for(int i = 0 ; i < N ; i++) map[i] = new ArrayList<>();
	    
	    for(int [] ar : edges){
	        map[ar[0]].add(new int[]{ar[1], ar[2]});
	    }
	    
// 		int vis[] = new int [N];
		 PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
		int [] ans = new int[N];
		Arrays.fill(ans, Integer.MAX_VALUE);
		helper(map, ans, 0, q);
		return ans;
	
	}
}