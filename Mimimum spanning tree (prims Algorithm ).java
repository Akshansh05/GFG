static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    
	    
	    int vis [] = new int[V];
	    
	    List<List<GraphNode>> adj = new ArrayList<>();
	    
	    for(int i=0; i<V;i++){
	        vis[i] = 0;
	        adj.add(new ArrayList<>());
	    }
	    
	    for(int i =0 ; i <E;i++){
	        int par = edges[i][0];
	        int child = edges[i][1];
	        int weight = edges[i][2];
	        
	        GraphNode n1 = new GraphNode(child,weight);
	        GraphNode n2 = new GraphNode(par,weight);
	        
	        adj.get(par).add(n1);
	        adj.get(child).add(n2);
	        
	    }
	    
	    PriorityQueue<Node> pq = new PriorityQueue<>(new c());
	    
	    Node n = new Node(0,-1,0);
	    
	    pq.add(n);
	    
	    int sum=0;
	    
	    while(!pq.isEmpty()){
	        
	        Node curr = pq.remove();
	        
	        if( vis[curr.node] ==0){
	            //add to mst
	        vis[curr.node] =1;
	        sum += curr.weight;
	        
	 
	        for(int i=0; i< adj.get(curr.node).size();i++){
	            
	            GraphNode ch  = adj.get(curr.node).get(i);
	            
	            if(vis[ch.child] == 0){
	                
	                Node newNode = new  Node(ch.child,curr.node,ch.weight);
	                
	                pq.add(newNode);
	                
	            }
	        }
	    }
	    }
	   
	   return sum; 
	    
	}
	
	static class Node {
	    int node;
	    int parent;
	    int weight;
	    
	    public Node(int node ,int parent, int weight){
	        this.node = node;
	        this.parent = parent;
	        this.weight = weight;
	    }
	}
	
	
	static class GraphNode {
	    int child;
	    int weight;
	    
	    public GraphNode(int child , int weight){
	        this.child = child;
	        this.weight = weight;
	    }
	}
	
	
	
	   static class c implements Comparator<Node>{
            
            public int compare(Node n1 , Node n2){
                
                return n1.weight - n2.weight;
            }
        }
	
}
