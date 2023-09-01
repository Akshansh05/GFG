// relax the weight V-1 Times  and for the last time check -ve cycle 

class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        
          int distance[] = new int[V];
    for(int i =0 ;i <V ;i++){
		    distance[i] = (int)1e8;

		}
		
		distance[S] =0;
		
		for(int i=0; i< V-1;i++){
		    
		    for(int j =0 ;j <edges.size();j++){
		        
		        int par = edges.get(j).get(0);
		        int child  = edges.get(j).get(1);
		        int weight  = edges.get(j).get(2);
		         
		        if(distance[child] > distance[par] + weight){
		             distance[child] = distance[par] + weight;
		        } 
		    }
		}
		
		//negative cycle check Nth Relaxation
		
		  for(int j =0 ;j <edges.size();j++){
		        
		        int par = edges.get(j).get(0);
		        int child  = edges.get(j).get(1);
		        int weight  = edges.get(j).get(2);
		         
		        if(distance[child]  != (int)1e8  && (distance[child] > distance[par] + weight)){
		             distance[child] = distance[par] + weight;
		             
		             return new int[]{-1};
		        } 
		    }
		
		
		
		return distance;
    }
}
