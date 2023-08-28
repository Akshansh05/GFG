class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        
         int inorder[] = new int[K];
         
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i =0 ;i <K ;i++){
             inorder[i]=0;
            adj.add(new ArrayList<>());
        }

        for(int i=0 ;i<dict.length-1;i++){
            
            String one  = dict[i];
            String two  = dict[i+1];
            
            int len = Math.min(one.length(),two.length());
            
            for(int j=0 ;j <len;j++){
                
                if(one.charAt(j) != two.charAt(j)){
                    
                    adj.get(one.charAt(j) -'a').add(two.charAt(j)-'a');
                    inorder[two.charAt(j)-'a']++;
                    break;
                }
            }
        }
        
     Queue<Integer> q = new LinkedList<>();
       
       for(int i=0;i<K;i++){
           if(inorder[i] ==0 ){
               q.add(i); 
           }
       }
       
       String s="";
      while(!q.isEmpty()){

           int curr = q.poll();
           s += (char) (curr +97); //topo sort 

           for(int val : adj.get(curr)){
               inorder[val]--; //reduce the inorder
               if(inorder[val] ==0){
                   q.add(val); //new parent
               }
           }
       }
        
        
      return s;
        
    }
}
