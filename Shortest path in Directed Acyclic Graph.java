class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
	
		//Code here
		// from given source to all nodes .
		
		//steps  1.do topo sort 
		//2.   do      distance[child.child] = Math.min(distance[child.child],distanceOfSourceToCurrToChild);

		
		int inorder[] = new int[N];
		 int distance[] = new int[N];
		
		 List<List<Node>> adj = new ArrayList<>();
		
		for(int i =0 ;i <N ;i++){
		    inorder[i] = 0;
		    distance[i] = (int)Math.pow(10,9);
		    adj.add(new ArrayList<Node>());
		}
		

    for(int i=0;i <M;i++){
        int par = edges[i][0];
        int child = edges[i][1];
        int weight = edges[i][2];
        
        Node n = new Node(child,weight);
        
        adj.get(par).add(n);
        
        inorder[child]++;
        
    }
    
    Queue<Integer> q = new LinkedList<>();
    
    
           for(int i=0;i<N;i++){
           if(inorder[i] ==0 ){
               q.add(i); 
           }
       }
       
       List<Integer> topo = new ArrayList<>();
       
       while(!q.isEmpty()){
           
           int curr = q.poll();
           
           topo.add(curr);
           
            for(Node val : adj.get(curr)){
               inorder[val.child]--; 
               if(inorder[val.child] ==0){
                   q.add(val.child); 
               }
           }
       }
       
    
       distance[0] = 0; // src distance as 0 
       
       for(int i =0;i < topo.size();i++){
           
           int curr = topo.get(i);
           
           for(Node child : adj.get(curr)){
               
               int distanceOfSourceToCurrToChild =   distance[curr] + child.weight; 
               
              distance[child.child] = Math.min(distance[child.child],distanceOfSourceToCurrToChild);
              
           }
       }
       
       for(int i=0; i< N;i++){
           
           if(distance[i] == (int)Math.pow(10,9)){
              distance[i] = -1; 
           }
       }
       
       return distance;
		
		
	}
	
	class Node{
	    int child ;
	    int weight;
	    public Node(int child ,int weight){
	        this.child = child;
	        this.weight = weight;
	    }
	}
}
