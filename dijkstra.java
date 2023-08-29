//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
 


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int N, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src)
    {
        // Write your code here
        
                int distance[] = new int[N];
                
                   for(int i =0 ;i <N ;i++){
		    distance[i] = (int)Math.pow(10,9);

		}
		
		
		
		distance [src] = 0;
		PriorityQueue<Node> pq = new  PriorityQueue<Node>(new c());
		
		Node n = new Node(src ,0);
		
		pq.add(n);
		
		while(!pq.isEmpty()){
		    
		    Node curr = pq.remove();
		    
		  for(int i=0; i< adj.get(curr.n).size();i++){
		      
		      List<Integer> l =  adj.get(curr.n).get(i);
		      
		      int child =  l.get(0);
		      int weightOfChild = l.get(1);
		      
		      if(distance[child]  > distance[curr.n] + weightOfChild){
		          
		          distance[child]  = distance[curr.n] + weightOfChild;
		          
		          Node newNode =  new Node(child,distance[child]);
		          pq.add(newNode);
		      }
		      
		  }
		}
		
		return distance;
        
    }
    
    static  class Node{
        
        int n;
        int dist;
        
        public Node(int n ,int dist){
            this.n =n;
            this.dist =dist;
        }
    }
        
        static class c implements Comparator<Node>{
            
            public int compare(Node n1 , Node n2){
                
                return n1.dist - n2.dist;
            }
        }
     
}

