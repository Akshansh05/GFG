class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        
          int distance[] = new int[n+1];
          int parent[] =  new int[n+1];
          
           List<List<GraphNode>> adj = new ArrayList<>();
         
         
         for(int i =0 ;i <=n ;i++){
            distance[i] = (int)Math.pow(10,9);
            parent[i] = i;
            adj.add(new ArrayList<GraphNode>());
        }
        
        
     for(int i=0;i <m;i++){
        int par = edges[i][0];
        int child = edges[i][1];
        int weight = edges[i][2];
         
         GraphNode childNode = new GraphNode(child,weight);
         
        GraphNode parentNode = new GraphNode(par,weight);
         
        adj.get(par).add(childNode);//undirected graph 
       adj.get(child).add(parentNode);//undirected graph 
        
    }
     PriorityQueue<Node> pq = new  PriorityQueue<Node>(new c());
            
            Node nd = new Node(1,0);
            
            distance[1] =0;
            parent[1]=1;
            
            pq.add(nd);
            
            while(!pq.isEmpty()){
                
                Node curr = pq.remove();
               
            for(GraphNode child : adj.get(curr.n)){
               
               int distanceOfSourceToCurrToChild =   distance[curr.n] + child.weight; 
               
               
               if(distance[child.child] > distanceOfSourceToCurrToChild ){
                
                distance[child.child] = distanceOfSourceToCurrToChild;
       
                 parent[child.child] = curr.n;
                 
                 Node newNodeDistance = new Node(child.child , distance[child.child]);
                 pq.add(newNodeDistance);   
               }
              
           }
            }
       
     List<Integer> ans = new  ArrayList<>();
     
         if(distance[n] == (int)Math.pow(10,9)){
        ans.add(-1);
        return ans;
    }
    
        int node = n;
        
        while(parent[node] != node){
            
            ans.add(node);
            node = parent[node];
        }
        ans.add(1);
        
        Collections.reverse(ans);
        
        return ans;
     
    }
    
     static class GraphNode{
        int child ;
        int weight;
        public GraphNode(int child ,int weight){
            this.child = child;
            this.weight = weight;
        }
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
