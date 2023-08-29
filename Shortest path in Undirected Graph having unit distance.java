Shortest path in Undirected Graph having unit distance  BFS

	//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int N,int M ,int src) {
        // Code here
        
        int distance[] = new int[N];

		 List<List<Integer>> adj = new ArrayList<>();
	

        for(int i =0 ;i <N ;i++){
		    distance[i] = (int)Math.pow(10,9);
		    adj.add(new ArrayList<Integer>());
		}
		
		
    for(int i=0;i <M;i++){
        int par = edges[i][0];
        int child = edges[i][1];
        adj.get(par).add(child);//undirected graph 
         adj.get(child).add(par);//undirected graph 
        
    }
		
		distance[src] = 0;
		
		 Queue<Integer> q = new LinkedList<>();
		 q.add(src);
		 
        while(!q.isEmpty()){
            
            int curr  = q.remove();
            
            for(int i= 0;i < adj.get(curr).size();i++){
                if(distance[adj.get(curr).get(i)] == (int)Math.pow(10,9) ){ //if unvisited 
          int distanceOfSourceToCurrToChild =   distance[curr] +  1; 
            distance[adj.get(curr).get(i)] =   Math.min(distance[adj.get(curr).get(i)],distanceOfSourceToCurrToChild);
                q.add(adj.get(curr).get(i));
                }
            }
        }
         for(int i=0; i< N;i++){
           
           if(distance[i] == (int)Math.pow(10,9)){
              distance[i] = -1; 
           }
       }
        
        return distance;
		
    }
}
